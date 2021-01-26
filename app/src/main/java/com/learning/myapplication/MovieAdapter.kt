package com.learning.myapplication

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.learning.myapplication.data.Movie
import com.learning.myapplication.utils.loadImage
import com.learning.myapplication.utils.setRating

class MovieAdapter(
    context: Context,
    var movies: List<Movie>,
    private val onMovieClick: OnMovieClicked
): RecyclerView.Adapter<ViewHolderInUse>() {
    fun isHeader(position: Int) = position == 0
    private var inflater = LayoutInflater.from(context)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolderInUse {
        return when(viewType){
            HEADER -> HeaderHolder(inflater.inflate(R.layout.view_holder_header, parent, false))
            MOVIE -> MoviesHolder(inflater.inflate(R.layout.view_holder_movie, parent, false))
            else -> throw IllegalArgumentException()
        }
    }

    override fun onBindViewHolder(holder: ViewHolderInUse, position: Int) {
        when(holder){
            is HeaderHolder -> holder.bind()
            is MoviesHolder -> {
                holder.bind(getItem(position))
                holder.itemView.setOnClickListener {
                    onMovieClick.onMovieClick(getItem(position))
                }
            }
        }
    }

    private fun getItem(position: Int): Movie = movies[position - 1]

    override fun getItemCount(): Int = movies.size + 1

    override fun getItemViewType(position: Int): Int{
        return when(position){
            0 -> HEADER
            else -> MOVIE
        }
    }

    companion object{
        const val HEADER = 0
        const val MOVIE = 1
    }
    
    interface OnMovieClicked{
        fun onMovieClick(movie: Movie)
    }
}

abstract class ViewHolderInUse(itemView: View): RecyclerView.ViewHolder(itemView)

class HeaderHolder(itemView: View) : ViewHolderInUse(itemView){
    private val headerImage: ImageView = itemView.findViewById(R.id.target_img)
    private val headerText: TextView = itemView.findViewById(R.id.movie_list_header_text)

    fun bind(){
        headerImage.setImageResource(R.drawable.target_blur)
        headerText.setText(R.string.movie_list)
    }
}

class MoviesHolder(itemView: View) : ViewHolderInUse(itemView){
    val mContext: Context = itemView.context
    private val previewImage: ImageView = itemView.findViewById(R.id.preview_movie_image)
    private val pgAge: TextView = itemView.findViewById(R.id.pg_age)
    private val genre: TextView =itemView.findViewById(R.id.genres)
    private val reviewNumber: TextView = itemView.findViewById(R.id.num_of_reviews)
    private val movieTitle: TextView = itemView.findViewById(R.id.movie_title)
    private val duration: TextView = itemView.findViewById(R.id.movie_duration)

    fun bind(movie: Movie){
        movieTitle.isSelected = true
        pgAge.text =  mContext.getString(R.string.age_limit, movie.minimumAge)
        genre.text = movie.genres.joinToString { it.name }
        reviewNumber.text = movie.numberOfRatings.toString()
        movieTitle.text = movie.title
        duration.text = movie.runtime.toString()
        loadImage(previewImage, movie.poster)
        setRating(itemView, movie.ratings)
    }
}
