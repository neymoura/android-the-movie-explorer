package com.ghost.themovieexplorer.extensions

import com.ghost.themovieexplorer.model.Image
import com.squareup.picasso.Picasso
import com.squareup.picasso.RequestCreator

fun Picasso.loadPath(path: String?): RequestCreator {
    return this.load(Image.getUrl(path ?: ""))
}