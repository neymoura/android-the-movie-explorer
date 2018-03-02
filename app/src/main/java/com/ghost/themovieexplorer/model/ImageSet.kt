package com.ghost.themovieexplorer.model

import io.realm.RealmList
import io.realm.RealmObject
import io.realm.annotations.PrimaryKey

open class ImageSet: RealmObject(){

    @PrimaryKey var id: String? = null
    var backdrops: RealmList<Image>? = null
    var posters: RealmList<Image>? = null

}