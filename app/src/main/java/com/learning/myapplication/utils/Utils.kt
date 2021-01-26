package com.learning.myapplication.utils

import android.view.View
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.CenterCrop
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import com.learning.myapplication.R
import kotlin.math.ceil


fun setRating(itemView: View, stars: Float){
        val converted = stars*5/10
        val star1 = itemView.findViewById<ImageView>(R.id.star1)
        val star2 = itemView.findViewById<ImageView>(R.id.star2)
        val star3 = itemView.findViewById<ImageView>(R.id.star3)
        val star4 = itemView.findViewById<ImageView>(R.id.star4)
        val star5 = itemView.findViewById<ImageView>(R.id.star5)

        when(converted.toInt()){
            0 -> {
                star1.setImageResource(R.drawable.star_off)
                star2.setImageResource(R.drawable.star_off)
                star3.setImageResource(R.drawable.star_off)
                star4.setImageResource(R.drawable.star_off)
                star5.setImageResource(R.drawable.star_off)
            }
            1 -> {
                star1.setImageResource(R.drawable.star_on)
                star2.setImageResource(R.drawable.star_off)
                star3.setImageResource(R.drawable.star_off)
                star4.setImageResource(R.drawable.star_off)
                star5.setImageResource(R.drawable.star_off)
            }
            2 -> {
                star1.setImageResource(R.drawable.star_on)
                star2.setImageResource(R.drawable.star_on)
                star3.setImageResource(R.drawable.star_off)
                star4.setImageResource(R.drawable.star_off)
                star5.setImageResource(R.drawable.star_off)
            }
            3 -> {
                star1.setImageResource(R.drawable.star_on)
                star2.setImageResource(R.drawable.star_on)
                star3.setImageResource(R.drawable.star_on)
                star4.setImageResource(R.drawable.star_off)
                star5.setImageResource(R.drawable.star_off)
            }
            4 -> {
                star1.setImageResource(R.drawable.star_on)
                star2.setImageResource(R.drawable.star_on)
                star3.setImageResource(R.drawable.star_on)
                star4.setImageResource(R.drawable.star_on)
                star5.setImageResource(R.drawable.star_off)
            }
            5 -> {
                star1.setImageResource(R.drawable.star_on)
                star2.setImageResource(R.drawable.star_on)
                star3.setImageResource(R.drawable.star_on)
                star4.setImageResource(R.drawable.star_on)
                star5.setImageResource(R.drawable.star_on)
            }
        }
    }

fun loadImage(view: ImageView, image: String){
        Glide.with(view.context)
            .load(image)
            .error(R.drawable.popcorn_load)
            .fallback(R.drawable.popcorn_load)
            .transform(CenterCrop(), RoundedCorners(20))
            .transition(DrawableTransitionOptions.withCrossFade())
            .into(view)
}