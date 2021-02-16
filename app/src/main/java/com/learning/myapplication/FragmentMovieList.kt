package com.learning.myapplication

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.learning.myapplication.api.ApiServiceInUse
import com.learning.myapplication.data.Movie
import com.learning.myapplication.data.Repository
import com.learning.myapplication.databinding.FragmentMovieListBinding
import kotlinx.coroutines.*

class FragmentMovieList : Fragment(R.layout.fragment_movie_list), Observer<Map<Int, Movie>> {

    private var clickListener: ClickListener? = null
    private var moviesListRecycler: RecyclerView? = null
    private val scope = CoroutineScope(Dispatchers.Main)

    private var _binding: FragmentMovieListBinding? = null
    private val binding get() = _binding!!
    lateinit var adapter: MovieAdapter
    lateinit var factory: MovieViewModelFactory
    lateinit var viewModel: MovieViewModel

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if(context is ClickListener){
            clickListener = context
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
       //viewModel = ViewModelProvider(requireActivity()).get(MovieViewModel::class.java)
        factory = MovieViewModelFactory(Repository(ApiServiceInUse(requireActivity())))
        viewModel = ViewModelProvider(requireActivity(), factory)
            .get(MovieViewModel::class.java)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentMovieListBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        adapter = MovieAdapter(onMovieData)

        val layout = GridLayoutManager(
            requireContext(),
            resources.getInteger(R.integer.grid_column_count),
            GridLayoutManager.VERTICAL,
            false
        )
        layout.spanSizeLookup = object: GridLayoutManager.SpanSizeLookup(){
            override fun getSpanSize(position: Int): Int {
                return if (adapter.isHeader(position)) layout.spanCount else 1
            }
        }
        binding.recyclerMovieList.adapter = adapter
        binding.recyclerMovieList.layoutManager = layout
    }

    override fun onStart() {
        super.onStart()
        viewModel.movieList.observe(this.viewLifecycleOwner, this)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onDestroy() {
        super.onDestroy()
        scope.cancel()
    }

    override fun onDetach() {
        super.onDetach()
        clickListener = null
    }

    override fun onChanged(t: Map<Int, Movie>?) {
        adapter.submitList(viewModel.movieList.value?.values?.toList())
    }

    private val onMovieData = object : MovieAdapter.OnMovieClick{
        override fun movieClicked(movie: Movie) {
            binding.recyclerMovieList?.let{
                clickListener?.onMovieDetailsClick(movie.id)
            }
        }
    }

    companion object{
        fun newInstance() = FragmentMovieList()
    }

    interface ClickListener {
        fun onMovieDetailsClick(movieId: Int)
    }
}