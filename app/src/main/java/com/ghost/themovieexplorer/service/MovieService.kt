package com.ghost.themovieexplorer.service

import com.ghost.themovieexplorer.application.TMEApplication
import com.ghost.themovieexplorer.model.ImageSet
import com.ghost.themovieexplorer.model.Movie
import com.ghost.themovieexplorer.model.MoviePage
import com.ghost.themovieexplorer.service.retrofit.RetrofitFactory
import io.realm.Realm
import io.realm.RealmObject
import io.realm.RealmResults
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.util.*

object MovieService {

    fun getMovies(): RealmResults<Movie>? {
        val realm = Realm.getDefaultInstance()
        return realm?.where(Movie::class.java)?.findAll()
    }

    fun getFavorites(): RealmResults<Movie>? {
        return getMovies()
    }

    fun getMovie(id: Long): Movie? {
        return try {
            getFavorites()?.toList()?.first { it.id == id }
        } catch (exception: Exception) {
            null
        }
    }

    fun queryMovies(query: String) {

        val parameters: MutableMap<String, String> = mutableMapOf()

        parameters["query"] = query
        parameters["language"] = Locale.getDefault().toString()
        parameters["api_key"] = TMEApplication.movieDBApiKey
        parameters["include_video"] = false.toString()
        parameters["include_adult"] = false.toString()

        val call = RetrofitFactory.theMovieDBAPI().queryMovies(parameters)

        call.enqueue(object : Callback<MoviePage?> {

            override fun onResponse(call: Call<MoviePage?>?, response: Response<MoviePage?>?) {
                TODO("not implemented")
            }

            override fun onFailure(call: Call<MoviePage?>?, t: Throwable?) {
                TODO("not implemented")
            }

        })

    }

    fun queryMovieDetails(movieId: Long) {

        val parameters: MutableMap<String, String> = mutableMapOf()

        parameters["append_to_response"] = "videos"
        parameters["language"] = Locale.getDefault().toString()
        parameters["api_key"] = TMEApplication.movieDBApiKey

        val call = RetrofitFactory.theMovieDBAPI().queryMovieDetails(movieId, parameters)

        call.enqueue(object : Callback<Movie> {

            override fun onResponse(call: Call<Movie>?, response: Response<Movie>?) {

                response?.let {
                    if (it.isSuccessful && it.body() != null) {
                        val movie: Movie = it.body()!!
                        save(movie)
                    } else {
                        TODO("not implemented")
                    }
                }

            }

            override fun onFailure(call: Call<Movie>?, t: Throwable?) {
                TODO("not implemented")
            }

        })

    }

    fun queryMovieImageSet(movieId: Long) {

        val parameters: MutableMap<String, String> = mutableMapOf()

        parameters["api_key"] = TMEApplication.movieDBApiKey

        val call = RetrofitFactory.theMovieDBAPI().queryMovieImageSet(movieId, parameters)

        call.enqueue(object : Callback<ImageSet> {

            override fun onResponse(call: Call<ImageSet>?, response: Response<ImageSet>?) {

                response?.let {
                    if (it.isSuccessful && it.body() != null) {
                        val imageSet: ImageSet = it.body()!!
                        save(imageSet)
                    } else {
                        TODO("not implemented")
                    }
                }

            }

            override fun onFailure(call: Call<ImageSet>?, t: Throwable?) {
                TODO("not implemented")
            }

        })

    }

    private fun save(data: RealmObject){
        val realm = Realm.getDefaultInstance()
        realm?.executeTransaction {
            it.copyToRealmOrUpdate(data)
        }
    }

}