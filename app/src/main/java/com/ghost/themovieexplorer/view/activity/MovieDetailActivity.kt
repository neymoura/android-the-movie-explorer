package com.ghost.themovieexplorer.view.activity

import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity
import android.view.MenuItem
import com.ghost.themovieexplorer.R
import com.ghost.themovieexplorer.extensions.loadPath
import com.ghost.themovieexplorer.model.Movie
import com.ghost.themovieexplorer.service.MovieService
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_movie_detail.*


class MovieDetailActivity : AppCompatActivity() {

    private val movie by lazy {
        val movieId = intent.extras.getLong(extraMovieId)
        MovieService.getMovie(movieId)
    }

    companion object {
        val extraMovieId: String = "MOVIE_ID"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_movie_detail)
        setSupportActionBar(toolbar)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        bind(movie)
        setupFab()

    }

    private fun setupFab() {
        fab.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                    .setAction("Action", null).show()
        }
    }

    private fun bind(movie: Movie?) {

        movie?.let {

            supportActionBar?.title = it.title

            Picasso.with(this@MovieDetailActivity)
                    .loadPath(movie.backdropPath ?: movie.posterPath)
                    .into(poster)

        }

    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            android.R.id.home -> {
                onBackPressed()
                true
            }
            else -> false
        }
    }

}
