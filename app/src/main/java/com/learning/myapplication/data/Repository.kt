package com.learning.myapplication.data

import com.learning.myapplication.api.ApiServiceInUse

class Repository(private val api: ApiServiceInUse) {
    suspend fun getMovies() = api.getMovies()
}
