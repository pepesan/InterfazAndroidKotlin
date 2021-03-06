package com.cursosdedesarrollo.interfazandroidkotlin

import androidx.fragment.app.Fragment
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton

/**
 * A placeholder fragment containing a simple view.
 */
class RecycleViewFragment : Fragment() {

    private var dato: String?=""

    lateinit var movieList: MutableList<Movie>
    private var mAdapter: MoviesFragmentAdapter? = null
    private var reciclerView: RecyclerView? = null
    private var fab: FloatingActionButton? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        //this.dato=(activity?.application as? Aplicacion)?.dato
        //Log.d("app:Main2ActFragment","Dato:"+this.dato)
        return inflater.inflate(R.layout.fragment_recycleview, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        (activity as AppCompatActivity).supportActionBar?.setDisplayHomeAsUpEnabled(false);
        movieList = (activity?.application as Aplicacion).movieList
        fab = view.findViewById(R.id.fab)
        fab?.setOnClickListener{
            saltaAdd()
            /*
            val movie: Movie = Movie("Matrix","CiFi", "1999")
            movieList.add(movie)
            prepareMovieData()
             */
        }
        mAdapter = MoviesFragmentAdapter(movieList, activity!!, this)
        val mLayoutManager = LinearLayoutManager(activity)
        this.reciclerView = view.findViewById(R.id.reciclerView)
        reciclerView!!.layoutManager = mLayoutManager
        reciclerView!!.itemAnimator = DefaultItemAnimator()
        reciclerView!!.adapter = mAdapter


        prepareMovieData()
    }
    private fun prepareMovieData() {
        mAdapter!!.notifyDataSetChanged()
    }

    fun saltaDetalle(position: Int){
        (activity?.application as Aplicacion).moviePosition = position
        findNavController().navigate(R.id.action_MovieFragment_to_detailMovieFragment)
    }
    fun saltaAdd(){
        findNavController().navigate(R.id.action_MovieFragment_to_addMovieFragment)
    }
}
