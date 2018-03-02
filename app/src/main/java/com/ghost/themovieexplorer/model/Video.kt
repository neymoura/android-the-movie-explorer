package com.ghost.themovieexplorer.model

import com.google.gson.annotations.SerializedName
import io.realm.RealmObject
import io.realm.annotations.PrimaryKey

open class Video : RealmObject() {

    @PrimaryKey
    var id: String? = null
    var key: String? = null
    var name: String? = null
    var site: String? = null

    @SerializedName("iso_639_1")
    var iso6391: String? = null

    @SerializedName("iso_3166_1")
    var iso31661: String? = null

}