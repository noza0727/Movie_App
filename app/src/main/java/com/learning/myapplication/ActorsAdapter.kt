package com.learning.myapplication

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.learning.myapplication.data.Actor
import com.learning.myapplication.utils.loadImage

class ActorsAdapter(context: Context, var actors: List<Actor>): RecyclerView.Adapter<ActorHolder>() {
    private var inflater = LayoutInflater.from(context)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ActorHolder {
        return ActorHolder(inflater.inflate(R.layout.view_holder_actor, parent, false))
    }

    override fun onBindViewHolder(holder: ActorHolder, position: Int) {
        holder.bind(getItem(position))
    }

    private fun getItem(position: Int): Actor = actors[position]
    override fun getItemCount(): Int = actors.size
}

class ActorHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
    private val picture: ImageView = itemView.findViewById(R.id.actor_image)
    private val name: TextView = itemView.findViewById(R.id.actor_name)

    fun bind(actors: Actor){
        name.text = actors.name
        loadImage(picture, actors.picture)
    }
}