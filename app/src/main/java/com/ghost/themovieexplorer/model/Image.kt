package com.ghost.themovieexplorer.model

import com.ghost.themovieexplorer.application.TMEApplication
import io.realm.RealmObject

open class Image : RealmObject() {

    var filePath: String? = null

    fun getUrl(): String {
        return "https://image.tmdb.org/t/p/w500/$filePath?api_key=${TMEApplication.movieDBApiKey}"
    }

}


