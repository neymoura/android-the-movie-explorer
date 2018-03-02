package com.ghost.themovieexplorer.model

import com.google.gson.annotations.SerializedName

class MoviePage {

    var page: Int? = null

    @SerializedName("total_results")
    var totalResults: Int? = null

    @SerializedName("total_pages")
    var totalPages: Int? = null

    var results: List<Movie>? = null

}