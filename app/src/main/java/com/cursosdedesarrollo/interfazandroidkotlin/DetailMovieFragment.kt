package com.cursosdedesarrollo.interfazandroidkotlin

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.fragment.findNavController
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
        activity?.title = "Movie Detail"
        (activity as AppCompatActivity).supportActionBar?.setDisplayHomeAsUpEnabled(true);
        setHasOptionsMenu(true)
        val aplicacion: Aplicacion =(activity?.application as Aplicacion)
        val position =  aplicacion.moviePosition
        val movie = aplicacion.movieList[position]
        detail_title.text= movie.title
        position_label_text.text = position.toString()


    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        return when (item.itemId) {
            android.R.id.home -> {
                findNavController().navigate(R.id.action_detailMovieFragment_to_MovieFragment)
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }


}