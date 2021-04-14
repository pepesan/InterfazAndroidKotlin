package com.cursosdedesarrollo.interfazandroidkotlin

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation.findNavController
import androidx.recyclerview.widget.RecyclerView


class MoviesFragmentAdapter(private val moviesList: List<Movie>, val context: Context, val fragment: Fragment)
    : RecyclerView.Adapter<MoviesFragmentAdapter.MyViewHolder>(){

    inner class MyViewHolder(view: View) : RecyclerView.ViewHolder(view) , View.OnClickListener{
        private var mItem: Movie? = null
        var title: TextView
        var year: TextView
        var genre: TextView
        var position: Int? = null

        init {
            title = view.findViewById<View>(R.id.title) as TextView
            genre = view.findViewById<View>(R.id.genre) as TextView
            year = view.findViewById<View>(R.id.year) as TextView
            view.setOnClickListener(this);

        }

        fun setItem(movie: Movie, position: Int) {
            mItem = movie
            title.text = movie.title
            genre.text = movie.genre
            year.text = movie.year
            this.position = position
        }

        override fun onClick(view: View) {
            // Saltar entre fragmentos
            Log.d("app:","Salto a detalle")
            (fragment as RecycleViewFragment).saltaDetalle(position!!)
        }

    }



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView = LayoutInflater.from(parent.context)
                .inflate(R.layout.movies_row, parent, false)

        return MyViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val movie = moviesList[position]
        holder.setItem(movie, position)
    }

    override fun getItemCount(): Int {
        return moviesList.size
    }
}