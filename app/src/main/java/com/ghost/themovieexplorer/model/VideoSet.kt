package com.ghost.themovieexplorer.model

import io.realm.RealmList
import io.realm.RealmObject

open class VideoSet : RealmObject() {

    var results: RealmList<Video>? = null

}