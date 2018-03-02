package com.ghost.themovieexplorer.view.activity

import android.os.Bundle
import android.support.v4.view.ViewPager
import android.support.v7.app.AppCompatActivity
import com.ghost.themovieexplorer.BuildConfig
import com.ghost.themovieexplorer.R
import com.ghost.themovieexplorer.adapter.MainMenuPageAdapter
import com.ghost.themovieexplorer.service.MovieService
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setupViewPager()
        setupNavigation()

        if (BuildConfig.DEBUG) {
            val movieId: Long = 152584
            MovieService.queryMovieDetails(movieId)
            MovieService.queryMovieImageSet(movieId)
        }

    }

    private fun setupViewPager() {

        viewPager.adapter = MainMenuPageAdapter(fragmentManager)
        viewPager.addOnPageChangeListener(object : ViewPager.OnPageChangeListener {
            override fun onPageScrollStateChanged(state: Int) {

            }

            override fun onPageScrolled(position: Int, positionOffset: Float, positionOffsetPixels: Int) {

            }

            override fun onPageSelected(position: Int) {

                val itemId = when (position) {
                    MainMenuPageAdapter.exploreFragment -> R.id.navigation_explore
                    MainMenuPageAdapter.favoritesFragment -> R.id.navigation_favorite
                    else -> null
                }

                itemId?.run {
                    navigation.selectedItemId = itemId
                }

            }
        })

    }

    private fun setupNavigation() {
        navigation.setOnNavigationItemSelectedListener {

            val position = when (it.itemId) {
                R.id.navigation_explore -> MainMenuPageAdapter.exploreFragment
                R.id.navigation_favorite -> MainMenuPageAdapter.favoritesFragment
                else -> null
            }

            position?.run {
                viewPager.currentItem = position
            }

            true

        }
    }

}
