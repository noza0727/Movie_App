package com.learning.myapplication

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.learning.myapplication.data.Movie
import com.learning.myapplication.databinding.ViewHolderHeaderBinding
import com.learning.myapplication.databinding.ViewHolderMovieBinding
import com.learning.myapplication.utils.loadImage
import com.learning.myapplication.utils.setRating

class MovieAdapter(
    private val onMovieClick: OnMovieClick
): ListAdapter<Movie, MovieAdapter.ViewHolderInUse>(MovieDiffUtil) {

    fun isHeader(position: Int) = position == 0

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolderInUse {
        val inflater = LayoutInflater.from(parent.context)
        return when (viewType) {
            ViewType.HEADER.ordinal -> {
                val binding = ViewHolderHeaderBinding.inflate(inflater, parent, false)
                ViewHolderInUse.HeaderHolder(binding)
            }
            ViewType.MOVIE.ordinal -> {
                val binding = ViewHolderMovieBinding.inflate(inflater, parent, false)
                ViewHolderInUse.MoviesHolder(binding)
            }
            else -> throw IllegalArgumentException()
        }
    }

    override fun onBindViewHolder(holder: ViewHolderInUse, position: Int) {
        when (holder) {
            is ViewHolderInUse.HeaderHolder -> holder.bind()
            is ViewHolderInUse.MoviesHolder -> {
                holder.bind(getItem(position))
                holder.itemView.setOnClickListener {
                    onMovieClick.movieClicked(getItem(position))
                }
            }
        }
    }

    override fun getItemViewType(position: Int): Int {
        return when (position) {
            0 -> ViewType.HEADER.ordinal
            else -> ViewType.MOVIE.ordinal
        }
    }

    enum class ViewType {
        HEADER,
        MOVIE
    }

    object MovieDiffUtil : DiffUtil.ItemCallback<Movie>() {
        override fun areItemsTheSame(oldItem: Movie, newItem: Movie): Boolean =
            oldItem.title == newItem.title

        override fun areContentsTheSame(oldItem: Movie, newItem: Movie): Boolean =
            oldItem == newItem
    }

    interface OnMovieClick {
        fun movieClicked(movie: Movie)
    }

    sealed class ViewHolderInUse(itemView: View) : RecyclerView.ViewHolder(itemView) {

        class HeaderHolder(private val binding: ViewHolderHeaderBinding) : ViewHolderInUse(binding.root) {

            fun bind() {
                binding.apply {
                    targetImg.setImageResource(R.drawable.target_blur)
                    movieListHeaderText.setText(R.string.movie_list)
                }
            }
        }

        class MoviesHolder(private val binding: ViewHolderMovieBinding) : ViewHolderInUse(binding.root) {
            fun bind(movie: Movie) {
                binding.apply {
                    movieTitle.isSelected = true
                    pgAge.text = binding.root.context.getString(R.string.age_limit, movie.minimumAge)
                    genres.text = movie.genres.joinToString { it.name }
                    numOfReviews.text = movie.numberOfRatings.toString()
                    movieTitle.text = movie.title
                    movieDuration.text = movie.runtime.toString()
                    loadImage(previewMovieImage, movie.poster)
                    setRating(itemView, movie.ratings)
                }
            }
        }
    }
}

