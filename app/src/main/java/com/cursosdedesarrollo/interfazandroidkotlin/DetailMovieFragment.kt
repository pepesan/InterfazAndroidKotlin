package com.cursosdedesarrollo.interfazandroidkotlin

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.content_movie_detail.*


/**
 * A simple [Fragment] subclass.
 * Use the [DetailMovieFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class DetailMovieFragment : Fragment() {


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_detail_movie, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val aplicacion: Aplicacion =(activity?.application as Aplicacion)
        val position =  aplicacion.moviePosition
        val movie = aplicacion.movieList.get(position)
        detail_title.text= movie.title
        position_label_text.text = position.toString()


    }


}