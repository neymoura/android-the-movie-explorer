package com.ghost.themovieexplorer.api

import com.ghost.themovieexplorer.model.ImageSet
import com.ghost.themovieexplorer.model.Movie
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.QueryMap

interface TheMovieDBAPI {

    @GET("/search/movie")
    fun queryMovies(@QueryMap options: Map<String, String>): Call<Page<Movie>>

    @GET("/movie/{movieId}/")
    fun queryMovieDetails(@Path("movieId") movieId: String, @QueryMap options: Map<String, String>): Call<Movie>

    @GET("/movie/{movieId}/images")
    fun queryMovieImageSet(@Path("movieId") movieId: String, @QueryMap options: Map<String, String>): Call<ImageSet>

}