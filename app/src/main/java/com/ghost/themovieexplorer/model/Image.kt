package com.ghost.themovieexplorer.model

import com.ghost.themovieexplorer.application.TMEApplication

data class Image(private val filePath: String) {

    fun getUrl(): String {
        return "https://image.tmdb.org/t/p/w500/$filePath?api_key=${TMEApplication.movieDBApiKey}"
    }

}


