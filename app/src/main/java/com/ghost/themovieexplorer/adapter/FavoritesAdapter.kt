package com.ghost.themovieexplorer.adapter

import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import com.ghost.themovieexplorer.model.Movie
import com.ghost.themovieexplorer.service.MovieService
import com.ghost.themovieexplorer.view.holder.MovieViewHolder

class FavoritesAdapter(private val itemClickListener: (View, Int, Int) -> Unit) : RecyclerView.Adapter<MovieViewHolder>() {

    override fun onCreateViewHolder(viewGroup: ViewGroup?, viewType: Int): MovieViewHolder {
        return MovieViewHolder.build(viewGroup!!).onItemClick(itemClickListener)
    }

    override fun getItemCount(): Int {
        return MovieService.getFavorites()?.size ?: 0
    }

    override fun getItemId(position: Int): Long {
        return MovieService.getFavorites()?.get(position)?.id ?: -1
    }

    override fun onBindViewHolder(holder: MovieViewHolder?, position: Int) {
        holder?.let {

            val movie: Movie? = MovieService.getFavorites()?.get(position)
            movie?.let {
                holder.bind(movie)
            }

        }
    }

    private fun <T : RecyclerView.ViewHolder> T.onItemClick(event: (view: View, position: Int, type: Int) -> Unit): T {
        itemView.setOnClickListener {
            event.invoke(it, adapterPosition, itemViewType)
        }
        return this
    }

}