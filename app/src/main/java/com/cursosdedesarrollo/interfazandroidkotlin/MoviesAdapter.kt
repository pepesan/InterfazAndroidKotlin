package com.cursosdedesarrollo.interfazandroidkotlin

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView


class MoviesAdapter(private val moviesList: List<Movie>,val context: Context) : RecyclerView.Adapter<MoviesAdapter.MyViewHolder>(){

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
            val intent = Intent(context ,MovieDetailActivity::class.java)
            intent.putExtra("title", mItem!!.title)
            intent.putExtra("position", position)
            (context as Activity).startActivity(intent)
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