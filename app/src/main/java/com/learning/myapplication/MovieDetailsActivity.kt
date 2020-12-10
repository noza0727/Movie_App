package com.learning.myapplication

import android.content.Intent
import android.graphics.Typeface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.FrameLayout
import android.widget.TextView


class MovieDetailsActivity : AppCompatActivity(), FragmentMovieList.ClickListener, FragmentMovieDetails.ClickListener {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        if(savedInstanceState == null){
            supportFragmentManager.beginTransaction()
                .replace(R.id.main_container, FragmentMovieList.newInstance(), FragmentMovieList::class.java.simpleName)
                .addToBackStack("trans:${FragmentMovieList}")
                .commit()
        }

    }


    override fun onMovieDetailsClick() {
        supportFragmentManager.beginTransaction()
            .add(R.id.main_container, FragmentMovieDetails.newInstance(), FragmentMovieDetails::class.java.simpleName)
            .addToBackStack("trans:${FragmentMovieDetails}")
            .commit()
    }

    override fun onBackToMovieList() {
        supportFragmentManager.popBackStack()

    }
}