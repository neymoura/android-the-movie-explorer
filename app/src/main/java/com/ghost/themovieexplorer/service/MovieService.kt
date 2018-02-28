package com.ghost.themovieexplorer.service

import com.ghost.themovieexplorer.model.Movie

object MovieService {

    fun getMovies(): List<Movie> {

        val favoritesList: MutableList<Movie> = mutableListOf()

        favoritesList.add(Movie(1, "Spirited Away", "https://images-na.ssl-images-amazon.com/images/M/MV5BOGJjNzZmMmUtMjljNC00ZjU5LWJiODQtZmEzZTU0MjBlNzgxL2ltYWdlXkEyXkFqcGdeQXVyNTAyODkwOQ@@._V1_SY1000_CR0,0,675,1000_AL_.jpg"))
        favoritesList.add(Movie(2, "Pulp Fiction", "https://images-na.ssl-images-amazon.com/images/M/MV5BMTkxMTA5OTAzMl5BMl5BanBnXkFtZTgwNjA5MDc3NjE@._V1_SY1000_CR0,0,673,1000_AL_.jpg"))
        favoritesList.add(Movie(3, "Interstellar", "https://images-na.ssl-images-amazon.com/images/M/MV5BZjdkOTU3MDktN2IxOS00OGEyLWFmMjktY2FiMmZkNWIyODZiXkEyXkFqcGdeQXVyMTMxODk2OTU@._V1_SY1000_SX675_AL_.jpg"))
        favoritesList.add(Movie(4, "Inception", "https://images-na.ssl-images-amazon.com/images/M/MV5BMjAxMzY3NjcxNF5BMl5BanBnXkFtZTcwNTI5OTM0Mw@@._V1_SY1000_CR0,0,675,1000_AL_.jpg"))

        return favoritesList

    }

    fun getMovie(id: Long): Movie? {
        return try {
            getFavorites().first { it.id == id }
        } catch (exception: Exception) {
            null
        }
    }

    fun getFavorites(): List<Movie> {
        return getMovies()
    }

}