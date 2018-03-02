package com.ghost.themovieexplorer.service

import com.ghost.themovieexplorer.api.Page
import com.ghost.themovieexplorer.application.TMEApplication
import com.ghost.themovieexplorer.model.ImageSet
import com.ghost.themovieexplorer.model.Movie
import com.ghost.themovieexplorer.service.retrofit.RetrofitFactory
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.util.*

object MovieService {

    fun getMovies(): List<Movie> {

        return mutableListOf()

    }

    fun getFavorites(): List<Movie> {
        return getMovies()
    }

    fun getMovie(id: Long): Movie? {
        return try {
            getFavorites().first { it.id == id }
        } catch (exception: Exception) {
            null
        }
    }

    fun queryMovies(query: String){

        val parameters: MutableMap<String, String> = mutableMapOf()

        parameters["query"] = query
        parameters["language"] = Locale.getDefault().toString()
        parameters["api_key"] = TMEApplication.movieDBApiKey
        parameters["include_video"] = false.toString()
        parameters["include_adult"] = false.toString()

        val call = RetrofitFactory.theMovieDBAPI().queryMovies(parameters)

        call.enqueue(object: Callback<Page<Movie>?> {

            override fun onResponse(call: Call<Page<Movie>?>?, response: Response<Page<Movie>?>?) {
                TODO("not implemented")
            }

            override fun onFailure(call: Call<Page<Movie>?>?, t: Throwable?) {
                TODO("not implemented")
            }

        })

    }

    fun queryMovieDetails(movieId: Long){

        val parameters: MutableMap<String, String> = mutableMapOf()

        parameters["append_to_response"] = "videos"
        parameters["language"] = Locale.getDefault().toString()
        parameters["api_key"] = TMEApplication.movieDBApiKey

        val call = RetrofitFactory.theMovieDBAPI().queryMovieDetails(movieId, parameters)

        call.enqueue(object: Callback<Movie> {

            override fun onResponse(call: Call<Movie>?, response: Response<Movie>?) {
                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            }

            override fun onFailure(call: Call<Movie>?, t: Throwable?) {
                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            }

        })

    }

    fun queryMovieImageSet(movieId: Long){

        val parameters: MutableMap<String, String> = mutableMapOf()

        parameters["api_key"] = TMEApplication.movieDBApiKey

        val call = RetrofitFactory.theMovieDBAPI().queryMovieImageSet(movieId, parameters)

        call.enqueue(object: Callback<ImageSet> {

            override fun onResponse(call: Call<ImageSet>?, response: Response<ImageSet>?) {
                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            }

            override fun onFailure(call: Call<ImageSet>?, t: Throwable?) {
                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            }

        })
    }

}