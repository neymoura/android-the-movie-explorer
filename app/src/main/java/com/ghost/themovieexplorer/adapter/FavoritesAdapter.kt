package com.ghost.themovieexplorer.adapter

import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import com.ghost.themovieexplorer.service.MovieService
import com.ghost.themovieexplorer.view.holder.MovieViewHolder
import kotlinx.android.synthetic.main.holder_movie.view.*

class FavoritesAdapter(private val itemClickListener: (View, Int, Int) -> Unit) : RecyclerView.Adapter<MovieViewHolder>() {

    override fun onCreateViewHolder(viewGroup: ViewGroup?, viewType: Int): MovieViewHolder {
        return MovieViewHolder.build(viewGroup!!).onItemClick(itemClickListener)
    }

    override fun getItemCount(): Int {
        return MovieService.getFavorites().size
    }

    override fun getItemId(position: Int): Long {
        return MovieService.getFavorites()[position].id
    }

    override fun onBindViewHolder(holder: MovieViewHolder?, position: Int) {
        holder?.let {
            holder.bind(MovieService.getFavorites()[position])
            holder.itemView.poster.transitionName = position.toString()
        }
    }

    private fun <T : RecyclerView.ViewHolder> T.onItemClick(event: (view: View, position: Int, type: Int) -> Unit): T {
        itemView.setOnClickListener {
            event.invoke(it, adapterPosition, itemViewType)
        }
        return this
    }

}