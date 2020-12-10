package com.learning.myapplication

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import java.util.zip.Inflater

class FragmentMovieDetails : Fragment(){

    private var clickListener: ClickListener? = null



    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_movie_details, container, false)
    }

    override fun onStart() {
        super.onStart()

        view?.findViewById<ImageView>(R.id.back_img)?.setOnClickListener {
            clickListener?.onBackToMovieList()
        }
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
        fun newInstance() = FragmentMovieDetails()
    }

    interface ClickListener{
        fun onBackToMovieList()
    }
}