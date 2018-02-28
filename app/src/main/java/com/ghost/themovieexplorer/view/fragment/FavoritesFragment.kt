package com.ghost.themovieexplorer.view.fragment

import android.app.Fragment
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.ghost.themovieexplorer.R
import com.ghost.themovieexplorer.adapter.FavoritesAdapter
import com.ghost.themovieexplorer.model.Movie
import com.ghost.themovieexplorer.service.MovieService
import com.ghost.themovieexplorer.view.activity.MovieDetailActivity
import kotlinx.android.synthetic.main.fragment_favorites.*
import org.jetbrains.anko.intentFor
import org.jetbrains.anko.singleTop

class FavoritesFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater!!.inflate(R.layout.fragment_favorites, container, false)
    }

    override fun onStart() {
        super.onStart()

        setupFavoritesList()

    }

    private fun setupFavoritesList() {

        val adapter = FavoritesAdapter({ _, position, _ ->
            val movie = MovieService.getMovie(favorites.adapter.getItemId(position))
            movie?.let { openMovieDetail(movie) }
        })

        favorites.adapter = adapter
        favorites.emptyView = emptyView
        adapter.notifyDataSetChanged()

    }

    private fun openMovieDetail(movie: Movie) {
        startActivity(intentFor<MovieDetailActivity>(MovieDetailActivity.extraMovieId to movie.id).singleTop())
    }

}
