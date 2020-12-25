package com.learning.myapplication

import android.content.Intent
import android.graphics.*
import android.graphics.drawable.BitmapDrawable
import android.media.Image
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.ViewOutlineProvider
import android.widget.FrameLayout
import android.widget.GridLayout
import android.widget.ImageView
import android.widget.TextView
import androidx.annotation.RequiresApi
import androidx.core.content.res.ResourcesCompat
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.learning.myapplication.data.MovieData


class MovieDetailsActivity: AppCompatActivity(), FragmentMovieList.ClickListener, FragmentMovieDetails.ClickListener {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        if(savedInstanceState == null){
            supportFragmentManager.beginTransaction()
                .add(R.id.main_container, FragmentMovieList.newInstance(), MOVIE_PASS)
                .addToBackStack("trans:${FragmentMovieList}")
                .commit()
        }else supportFragmentManager.findFragmentByTag(MOVIE_PASS) as? FragmentMovieList

    }



    override fun onMovieDetailsClick(movie: Movies) {
        supportFragmentManager.beginTransaction()
            .add(R.id.main_container, FragmentMovieDetails.newInstance(movie))
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