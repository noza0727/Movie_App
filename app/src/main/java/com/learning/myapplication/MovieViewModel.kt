package com.learning.myapplication

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.learning.myapplication.data.Movie
import com.learning.myapplication.data.Repository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MovieViewModel(private val repository: Repository): ViewModel() {
    private val _mutableMovieList = MutableLiveData<Map<Int, Movie>>()
    val movieList: MutableLiveData<Map<Int, Movie>> get() =_mutableMovieList

    init {
        CoroutineScope(Dispatchers.IO).launch {
            _mutableMovieList.postValue(getMovies())
        }
    }

    fun getMovie(id: Int) = _mutableMovieList.value?.get(id)!!

    suspend fun getMovies() = repository.getMovies().associateBy { it.id }
}

