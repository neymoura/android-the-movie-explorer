package com.ghost.themovieexplorer.model

import com.ghost.themovieexplorer.api.Result

data class Movie(val id: Long,
                 val title: String,
                 val originalTitle: String,
                 val overview: String,
                 val posterPath: String,
                 val backdropPath: String,
                 val videos: Result<Video>,
                 val imageSet: ImageSet
)