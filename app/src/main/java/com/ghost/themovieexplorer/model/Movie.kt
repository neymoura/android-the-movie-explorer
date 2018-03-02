package com.ghost.themovieexplorer.model

import io.realm.Realm
import io.realm.RealmObject
import io.realm.annotations.PrimaryKey

open class Movie : RealmObject() {

    @PrimaryKey
    var id: Long? = null
    var title: String? = null
    var originalTitle: String? = null
    var overview: String? = null
    var posterPath: String? = null
    var backdropPath: String? = null
    var videos: VideoSet? = null

    fun getImageSet(): ImageSet? {

        val realm = Realm.getDefaultInstance()

        var imageSet: ImageSet? = null

        realm?.let {
            imageSet = it.where(ImageSet::class.java).equalTo("id", id).findFirst()
        }

        realm?.close()

        return imageSet

    }

}