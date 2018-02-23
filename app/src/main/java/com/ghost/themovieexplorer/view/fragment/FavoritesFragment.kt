package com.ghost.themovieexplorer.view.fragment

import android.app.Fragment
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.ghost.themovieexplorer.R
import com.ghost.themovieexplorer.adapter.FavoritesAdapter
import kotlinx.android.synthetic.main.fragment_favorites.*

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
        val adapter = FavoritesAdapter()
        favorites.adapter = adapter
        favorites.emptyView = emptyView
        adapter.notifyDataSetChanged()
    }

}
