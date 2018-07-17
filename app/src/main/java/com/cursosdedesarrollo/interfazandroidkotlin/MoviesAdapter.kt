package com.cursosdedesarrollo.interfazandroidkotlin

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView

class MoviesAdapter(private val moviesList: List<Movie>) : RecyclerView.Adapter<MoviesAdapter.MyViewHolder>() {

    inner class MyViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        var title: TextView
        var year: TextView
        var genre: TextView

        init {
            title = view.findViewById<View>(R.id.title) as TextView
            genre = view.findViewById<View>(R.id.genre) as TextView
            year = view.findViewById<View>(R.id.year) as TextView
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView = LayoutInflater.from(parent.context)
                .inflate(R.layout.movies_row, parent, false)

        return MyViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val movie = moviesList[position]
        holder.title.text = movie.title
        holder.genre.text = movie.genre
        holder.year.text = movie.year
    }

    override fun getItemCount(): Int {
        return moviesList.size
    }
}