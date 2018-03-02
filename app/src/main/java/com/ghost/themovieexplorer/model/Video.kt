package com.ghost.themovieexplorer.model

import io.realm.RealmObject
import io.realm.annotations.PrimaryKey

open class Video : RealmObject() {

    @PrimaryKey
    var id: String? = null
    var key: String? = null
    var name: String? = null
    var site: String? = null
    var iso6391: String? = null
    var iso31661: String? = null

}