package com.ghost.themovieexplorer.api

class Page<T>(val page: Int,
              val totalResults: Int,
              val totalPages: Int,
              val results: List<T>)