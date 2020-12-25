package com.learning.myapplication

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.learning.myapplication.utils.setRating


class FragmentMovieDetails : Fragment(){

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
            findViewById<TextView>(R.id.back_text)?.setOnClickListener{
                clickListener?.onBackToMovieList()
            }
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        var actors: List<Actors> = emptyList()



        arguments?.apply {
            val movie = getParcelable<Movies>(MOVIE)
            view.findViewById<TextView>(R.id.movie_title).text = movie?.title
            view.findViewById<TextView>(R.id.pg_age).text = movie?.pg_age
            view.findViewById<TextView>(R.id.genres).text = movie?.genre
            view.findViewById<TextView>(R.id.num_of_reviews).text = movie?.reviews
            view.findViewById<TextView>(R.id.short_story).text = movie?.description
            movie?.previewImage?.let {
                view.findViewById<ImageView>(R.id.preview_movie_image).setImageResource(it)
            }
                actors = movie!!.actors
                setRating(view, movie.rating)

        }

        actorListRecycler = view.findViewById(R.id.actors_recycler_view)
        val adapter = ActorsAdapter(requireContext(), actors)
        actorListRecycler?.layoutManager =
            LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
        actorListRecycler?.adapter = adapter

    }


    override fun onAttach(context: Context) {
        super.onAttach(context)
        if(context is FragmentMovieDetails.ClickListener){
            clickListener = context
        }
    }

    override fun onDetach() {
        super.onDetach()
        clickListener = null
    }

    companion object{
        fun newInstance(movie: Movies) :  FragmentMovieDetails{
            val fragmentDetailsPass = FragmentMovieDetails()
            val args = Bundle()
               args.putParcelable(MOVIE, movie)
            fragmentDetailsPass.arguments = args
            return fragmentDetailsPass
        }

        const val MOVIE = "Movie"
    }

    interface ClickListener{
        fun onBackToMovieList()
    }
}