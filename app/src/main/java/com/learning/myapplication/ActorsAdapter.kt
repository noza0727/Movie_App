package com.learning.myapplication

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.learning.myapplication.data.Actor
import com.learning.myapplication.databinding.ViewHolderActorBinding
import com.learning.myapplication.utils.loadImage

class ActorsAdapter(): ListAdapter<Actor, ActorsAdapter.ActorHolder>(ActorDiffUtil) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ActorHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ViewHolderActorBinding.inflate(inflater, parent, false)
        return ActorHolder(binding)
    }

    override fun onBindViewHolder(holder: ActorHolder, position: Int) {
        holder.bind(getItem(position))
    }

    class ActorHolder(private val binding: ViewHolderActorBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bind(actors: Actor) {
            binding.apply{
                actorName.text = actors.name
                loadImage(actorImage, actors.picture)
            }
        }
    }

    object ActorDiffUtil : DiffUtil.ItemCallback<Actor>() {
        override fun areItemsTheSame(oldItem: Actor, newItem: Actor): Boolean =
            oldItem.name == newItem.name

        override fun areContentsTheSame(oldItem: Actor, newItem: Actor): Boolean =
            oldItem == newItem
    }
}




