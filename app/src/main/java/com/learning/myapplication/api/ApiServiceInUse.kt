package com.learning.myapplication.api

import android.content.Context
import com.learning.myapplication.data.Movie
import com.learning.myapplication.data.loadMovies

class ApiServiceInUse(val context: Context) : ApiService{
    override suspend fun getMovies(): List<Movie> = loadMovies(context)
}
