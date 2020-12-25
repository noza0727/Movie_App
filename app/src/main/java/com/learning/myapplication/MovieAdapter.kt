package com.learning.myapplication

import android.content.Context
import android.media.Image
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.learning.myapplication.utils.setRating
import org.w3c.dom.Text

class MovieAdapter(context: Context, var movies: List<Movies>, val onMovieClick: OnMovieClicked): RecyclerView.Adapter<ViewHolderInUse>() {

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
                holder.itemView.setOnClickListener{
                    onMovieClick.onMovieClick(getItem(position))
                }
            }
        }
    }

    private fun getItem(position: Int): Movies = movies[position-1]

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
        fun onMovieClick(movie: Movies)
    }

}
 abstract class ViewHolderInUse (itemView: View): RecyclerView.ViewHolder(itemView)


class HeaderHolder(itemView: View) : ViewHolderInUse(itemView){
    val headerImage: ImageView = itemView.findViewById(R.id.target_img)
    val headerText: TextView = itemView.findViewById(R.id.movie_list_header_text)

    fun bind(){
        headerImage.setImageResource(R.drawable.target_blur)
        headerText.setText(R.string.movie_list)
    }
}

class MoviesHolder(itemView: View) : ViewHolderInUse(itemView){
    private val previewImage: ImageView = itemView.findViewById(R.id.preview_movie_image)
    val pgAge = itemView.findViewById<TextView>(R.id.pg_age)
    val genre =itemView.findViewById<TextView>(R.id.genres)
    val reviewNumber = itemView.findViewById<TextView>(R.id.num_of_reviews)
    val movieTitle = itemView.findViewById<TextView>(R.id.movie_title)
    val duration = itemView.findViewById<TextView>(R.id.movie_duration)


    fun bind(movie: Movies){
        previewImage.setImageResource(movie.previewImage)
        pgAge.text = movie.pg_age
        genre.text = movie.genre
        reviewNumber.text = movie.reviews
        movieTitle.text = movie.title
        duration.text = movie.duration
        setRating(itemView, movie.rating)
    }

}
