package com.learning.myapplication

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.learning.myapplication.data.Actor
import com.learning.myapplication.databinding.FragmentMovieDetailsBinding
import com.learning.myapplication.utils.*


class FragmentMovieDetails : Fragment(R.layout.fragment_movie_details) {

    private var clickListener: ClickListener? = null
    private var _binding: FragmentMovieDetailsBinding? = null
    private val binding get() = _binding!!
    private lateinit var viewModel: MovieViewModel

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is ClickListener) {
            clickListener = context
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.v("FragmentMovieList", "inside onCreate")
        viewModel = ViewModelProvider(requireActivity()).get(MovieViewModel::class.java)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentMovieDetailsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        putMovieDetailsInfo(view)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onDetach() {
        super.onDetach()
        clickListener = null
    }

    private fun putMovieDetailsInfo(view: View) {
        var actors: List<Actor>
        val adapter = ActorsAdapter()
        arguments?.apply {
            val movieId = getInt(MOVIE)
            Log.v("Fragment Movie List: ", "movieId = $movieId")
            val movie = viewModel.getMovie(movieId)
            binding.backImg.setOnClickListener { clickListener?.onBackToMovieList() }
            binding.backText.setOnClickListener{ clickListener?.onBackToMovieList() }
            binding.movieTitle.text = movie.title
            binding.pgAge.text = movie.minimumAge.toString()
            binding.genres.text = movie.genres.joinToString { it.name }
            binding.shortStory.text = movie.overview
            movie.backdrop.let { loadImage(binding.previewMovieImage, it) }
            setRating(view, movie.ratings)
            actors = movie.actors
            adapter.submitList(actors)
            if(actors.isEmpty())
                    binding.cast.text = getString(R.string.no_cast)
        }
        binding.actorsRecyclerView.adapter = adapter
        binding.actorsRecyclerView.layoutManager =
            LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
    }

    companion object {
        fun newInstance(id: Int) = FragmentMovieDetails().apply {
            arguments = Bundle().apply {
                putInt(MOVIE, id)
            }
        }
        const val MOVIE = "Movie"
    }

    interface ClickListener {
        fun onBackToMovieList()
    }
}

