package com.ghost.themovieexplorer.view.holder

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.ghost.themovieexplorer.R
import com.ghost.themovieexplorer.extensions.loadPath
import com.ghost.themovieexplorer.model.Movie
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.holder_movie.view.*

class MovieViewHolder(private val view: View) : RecyclerView.ViewHolder(view) {

    companion object {
        fun build(viewGroup: ViewGroup): MovieViewHolder {
            val view = LayoutInflater.from(viewGroup.context).inflate(R.layout.holder_movie, viewGroup, false)
            return MovieViewHolder(view)
        }
    }

    fun bind(movie: Movie) {

        with(view) {

            Picasso.with(context).loadPath(movie.posterPath).into(poster)

        }

    }

}