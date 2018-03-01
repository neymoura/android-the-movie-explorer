package com.ghost.themovieexplorer.service.retrofit

import com.ghost.themovieexplorer.api.TheMovieDBAPI
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitFactory {

    companion object {

        private val retrofit = Retrofit.Builder()
                .baseUrl("https://api.themoviedb.org/3")
                .addConverterFactory(GsonConverterFactory.create())
                .build()

        fun theMovieDBAPI() = retrofit.create(TheMovieDBAPI::class.java)

    }

}