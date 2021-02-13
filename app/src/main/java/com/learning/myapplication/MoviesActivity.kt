package com.learning.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MoviesActivity: AppCompatActivity(), FragmentMovieList.ClickListener, FragmentMovieDetails.ClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        if(savedInstanceState == null){
            supportFragmentManager.beginTransaction()
                .add(R.id.main_container, FragmentMovieList.newInstance(), MOVIE_PASS)
                .addToBackStack("trans:${FragmentMovieList}")
                .commit()
        }
        else supportFragmentManager.findFragmentByTag(MOVIE_PASS) as? FragmentMovieList
    }

    override fun onMovieDetailsClick(movieId: Int) {
        supportFragmentManager.beginTransaction()
            .add(R.id.main_container, FragmentMovieDetails.newInstance(movieId))
            .addToBackStack("trans:${FragmentMovieDetails}")
            .commit()
    }

    override fun onBackToMovieList() {
        supportFragmentManager.popBackStack()
    }

    companion object{
        const val MOVIE_PASS = "MovieDataToPass"
    }
}