package com.learning.myapplication

import android.content.Context
import android.media.Image
import android.text.Layout
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import kotlin.math.acos

class ActorsAdapter(context: Context, var actors: List<Actors>): RecyclerView.Adapter<ActorHolder>() {


    private var inflater = LayoutInflater.from(context)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ActorHolder {
        return ActorHolder(inflater.inflate(R.layout.view_holder_actor, parent, false))
    }

    override fun onBindViewHolder(holder: ActorHolder, position: Int) {
        holder.bind(getItem(position))
    }

    fun getItem(position: Int): Actors = actors[position]
    override fun getItemCount(): Int = actors.size

}

class ActorHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
    private val picture: ImageView = itemView.findViewById(R.id.actor_image)
    private val fullname: TextView = itemView.findViewById(R.id.actor_name)

    fun bind(actors: Actors){
        picture.setImageResource(actors.picture)
        fullname.text = actors.fullName
    }
}