package com.cursosdedesarrollo.interfazandroidkotlin

import android.os.Bundle

import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.content_recycler_view.*
import android.support.v7.widget.DefaultItemAnimator



class RecyclerViewActivity : AppCompatActivity() {

    private var movieList: MutableList<Movie> = mutableListOf()
    private var mAdapter: MoviesAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recycler_view)
        mAdapter = MoviesAdapter(movieList)
        val mLayoutManager = LinearLayoutManager(applicationContext)
        reciclerView!!.layoutManager = mLayoutManager
        reciclerView!!.itemAnimator = DefaultItemAnimator()
        reciclerView!!.adapter = mAdapter

        prepareMovieData()
    }

    private fun prepareMovieData() {
        var movie = Movie("Mad Max: Fury Road", "Action & Adventure", "2015")
        movieList.add(movie)

        movie = Movie("Inside Out", "Animation, Kids & Family", "2015")
        movieList.add(movie)

        movie = Movie("Star Wars: Episode VII - The Force Awakens", "Action", "2015")
        movieList.add(movie)

        movie = Movie("Shaun the Sheep", "Animation", "2015")
        movieList.add(movie)

        movie = Movie("The Martian", "Science Fiction & Fantasy", "2015")
        movieList.add(movie)

        movie = Movie("Mission: Impossible Rogue Nation", "Action", "2015")
        movieList.add(movie)

        movie = Movie("Up", "Animation", "2009")
        movieList.add(movie)

        movie = Movie("Star Trek", "Science Fiction", "2009")
        movieList.add(movie)

        movie = Movie("The LEGO Movie", "Animation", "2014")
        movieList.add(movie)

        movie = Movie("Iron Man", "Action & Adventure", "2008")
        movieList.add(movie)

        movie = Movie("Aliens", "Science Fiction", "1986")
        movieList.add(movie)

        movie = Movie("Chicken Run", "Animation", "2000")
        movieList.add(movie)

        movie = Movie("Back to the Future", "Science Fiction", "1985")
        movieList.add(movie)

        movie = Movie("Raiders of the Lost Ark", "Action & Adventure", "1981")
        movieList.add(movie)

        movie = Movie("Goldfinger", "Action & Adventure", "1965")
        movieList.add(movie)

        movie = Movie("Guardians of the Galaxy", "Science Fiction & Fantasy", "2014")
        movieList.add(movie)

        mAdapter!!.notifyDataSetChanged()
    }

}
