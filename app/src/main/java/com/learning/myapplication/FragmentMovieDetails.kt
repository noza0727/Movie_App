package com.learning.myapplication

import android.content.Context
import android.content.res.Resources
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import com.learning.myapplication.data.Actor
import com.learning.myapplication.data.Movie
import com.learning.myapplication.utils.*

class FragmentMovieDetails : Fragment() {

    private var clickListener: ClickListener? = null
    private var actorListRecycler: RecyclerView? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        return inflater.inflate(R.layout.fragment_movie_details, container, false).apply {
            findViewById<ImageView>(R.id.back_img)?.setOnClickListener {
                clickListener?.onBackToMovieList()
            }
            findViewById<TextView>(R.id.back_text)?.setOnClickListener {
                clickListener?.onBackToMovieList()
            }
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        putMovieDetailsInfo(view)
    }

    private fun putMovieDetailsInfo(view: View) {
        var actors: List<Actor> = emptyList()
        val backImage = view.findViewById<ImageView>(R.id.preview_movie_image)
        arguments?.apply {
            val movie = getParcelable<Movie>(MOVIE)
            view.findViewById<TextView>(R.id.movie_title).text = movie?.title
            view.findViewById<TextView>(R.id.pg_age).text = getString(R.string.age_limit, movie?.minimumAge)
            view.findViewById<TextView>(R.id.genres).text = movie?.genres?.joinToString { it.name }
            view.findViewById<TextView>(R.id.num_of_reviews).text = movie?.ratings.toString()
            view.findViewById<TextView>(R.id.short_story).text = movie?.overview
            movie?.backdrop?.let { loadImage(backImage, it) }
            if (movie != null) {
                setRating(view, movie.ratings)
                actors = movie.actors
                if(actors.isEmpty())
                    view.findViewById<TextView>(R.id.cast).text = getString(R.string.no_cast)
            }
        }
        actorListRecycler = view.findViewById(R.id.actors_recycler_view)
        actorListRecycler?.layoutManager =
            LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
        actorListRecycler?.adapter =  ActorsAdapter(requireContext(), actors)
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is ClickListener) {
            clickListener = context
        }
    }

    override fun onDetach() {
        super.onDetach()
        clickListener = null
    }

    companion object {
        fun newInstance(movie: Movie): FragmentMovieDetails {
            val fragmentDetailsPass = FragmentMovieDetails()
            val args = Bundle()
            args.putParcelable(MOVIE, movie)
            fragmentDetailsPass.arguments = args
            return fragmentDetailsPass
        }
        const val MOVIE = "Movie"
    }

    interface ClickListener {
        fun onBackToMovieList()
    }
}