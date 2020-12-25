package com.learning.myapplication.utils

import android.view.View
import android.widget.ImageView
import com.learning.myapplication.R


     fun setRating(itemView: View, stars: Int){
        val star1 = itemView.findViewById<ImageView>(R.id.star1)
        val star2 = itemView.findViewById<ImageView>(R.id.star2)
        val star3 = itemView.findViewById<ImageView>(R.id.star3)
        val star4 = itemView.findViewById<ImageView>(R.id.star4)
        val star5 = itemView.findViewById<ImageView>(R.id.star5)

        when(stars){
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
