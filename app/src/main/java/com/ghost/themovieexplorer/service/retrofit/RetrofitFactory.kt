package com.ghost.themovieexplorer.service.retrofit

import com.ghost.themovieexplorer.BuildConfig
import com.ghost.themovieexplorer.api.TheMovieDBAPI
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitFactory {

    companion object {

        private fun retrofitBuilder(): Retrofit.Builder {

            val builder = Retrofit.Builder()
            builder.baseUrl("https://api.themoviedb.org/3/")
            builder.addConverterFactory(GsonConverterFactory.create())

            if (BuildConfig.DEBUG) {

                val loggingInterceptor = HttpLoggingInterceptor()
                loggingInterceptor.level = HttpLoggingInterceptor.Level.BODY

                val clientBuilder = OkHttpClient().newBuilder()
                clientBuilder.addInterceptor(loggingInterceptor)

                val client = clientBuilder.build()

                builder.client(client)

            }

            return builder

        }

        private val retrofit = retrofitBuilder().build()

        fun theMovieDBAPI() = retrofit.create(TheMovieDBAPI::class.java)!!

    }

}