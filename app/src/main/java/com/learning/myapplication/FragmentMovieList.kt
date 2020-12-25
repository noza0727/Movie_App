package com.learning.myapplication

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.card.MaterialCardView
import com.learning.myapplication.data.MovieData

class FragmentMovieList : Fragment() {

    private var clickListener: ClickListener? = null
    private var moviesListRecycler: RecyclerView? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

      return inflater.inflate(R.layout.fragment_movie_list, container, false)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        moviesListRecycler = view.findViewById(R.id.recycler_movie_list)
        val movies = MovieData.generateMovies()
        val adapter = MovieAdapter(requireContext(), movies, onMovieData)
        val layout = GridLayoutManager(requireContext(), resources.getInteger(R.integer.grid_column_count), GridLayoutManager.VERTICAL,false )
        layout.spanSizeLookup = object: GridLayoutManager.SpanSizeLookup(){
            override fun getSpanSize(position: Int): Int {
                return if (adapter.isHeader(position)) layout.spanCount else 1
            }
        }

        moviesListRecycler?.layoutManager = layout
        moviesListRecycler?.adapter = adapter

    }



    override fun onAttach(context: Context) {
        super.onAttach(context)
        if(context is ClickListener){
            clickListener = context
        }
    }

    override fun onDetach() {
        super.onDetach()
        clickListener = null
    }

    private val onMovieData = object : MovieAdapter.OnMovieClicked{
        override fun onMovieClick(movie: Movies) {
            moviesListRecycler?.let{
                clickListener?.onMovieDetailsClick(movie)
            }

        }

    }

    companion object{
        fun newInstance() = FragmentMovieList()
    }

    interface ClickListener {
        fun onMovieDetailsClick(movie: Movies)
    }
}