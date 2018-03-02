package com.ghost.themovieexplorer.model

import com.ghost.themovieexplorer.application.TMEApplication
import com.google.gson.annotations.SerializedName
import io.realm.RealmObject

open class Image : RealmObject() {

    companion object {
        fun getUrl(path: String): String{
            return "https://image.tmdb.org/t/p/w500/$path?api_key=${TMEApplication.movieDBApiKey}"
        }
    }

    @SerializedName("file_path")
    var filePath: String = ""

    fun getUrl(): String {
        return Companion.getUrl(filePath)
    }

}


