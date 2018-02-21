package com.ghost.themovieexplorer.adapter

import android.app.Fragment
import android.app.FragmentManager
import android.support.v13.app.FragmentPagerAdapter
import com.ghost.themovieexplorer.view.fragment.ExploreFragment
import com.ghost.themovieexplorer.view.fragment.FavoritesFragment

class MainMenuPageAdapter(fragmentManager: FragmentManager) : FragmentPagerAdapter(fragmentManager) {

    companion object {
        val exploreFragment = 0
        val favoritesFragment = 1
    }

    override fun getItem(position: Int): Fragment {

        return when (position) {
            exploreFragment -> ExploreFragment()
            favoritesFragment -> FavoritesFragment()
            else -> Fragment()
        }

    }

    override fun getCount(): Int {
        return 2
    }

}