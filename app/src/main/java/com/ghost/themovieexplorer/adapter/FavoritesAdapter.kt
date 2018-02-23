package com.ghost.themovieexplorer.adapter

import android.support.v7.widget.RecyclerView
import android.view.ViewGroup
import com.ghost.themovieexplorer.service.MovieService
import com.ghost.themovieexplorer.view.holder.MovieViewHolder

class FavoritesAdapter: RecyclerView.Adapter<MovieViewHolder>() {

    override fun onCreateViewHolder(viewGroup: ViewGroup?, viewType: Int): MovieViewHolder {
        return MovieViewHolder.build(viewGroup!!)
    }

    override fun getItemCount(): Int {
        return MovieService.getFavorites().size
    }

    override fun onBindViewHolder(holder: MovieViewHolder?, position: Int) {
        holder?.let {
            holder.bind(MovieService.getFavorites()[position])
        }
    }

}