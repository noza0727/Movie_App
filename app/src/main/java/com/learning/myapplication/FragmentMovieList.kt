package com.learning.myapplication

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.google.android.material.card.MaterialCardView

class FragmentMovieList : Fragment() {

    private var clickListener: ClickListener? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

      return inflater.inflate(R.layout.fragment_movie_list, container, false)

    }

    override fun onStart() {
        super.onStart()

        view?.findViewById<View>(R.id.movie_card_layout)?. setOnClickListener{
                clickListener?.onMovieDetailsClick()
            }
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if(context is ClickListener){
            clickListener = context
        }
    }

    override fun onDetach() {
        super.onDetach()
        clickListener = null
    }

    companion object{
        fun newInstance() = FragmentMovieList()
    }

    interface ClickListener {
        fun onMovieDetailsClick()
    }
}