package com.learning.myapplication.api

import com.learning.myapplication.data.Movie

interface ApiService{
    suspend fun getMovies(): List<Movie>
}

