package com.cursosdedesarrollo.interfazandroidkotlin

import android.content.Intent
import android.os.Bundle

import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.content_recycler_view.*
import android.support.v7.widget.DefaultItemAnimator
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.view.View
import kotlinx.android.synthetic.main.activity_listados.*
import android.widget.AdapterView.OnItemClickListener




class RecyclerViewActivity : AppCompatActivity() {

    lateinit var movieList: MutableList<Movie>
    private var mAdapter: MoviesAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recycler_view)
        setSupportActionBar(toolbar)
        Log.d("app:RecyclerView","onCreate")
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        movieList = (application as Aplicacion).movieList

        mAdapter = MoviesAdapter(movieList)
        val mLayoutManager = LinearLayoutManager(applicationContext)
        reciclerView!!.layoutManager = mLayoutManager
        reciclerView!!.itemAnimator = DefaultItemAnimator()
        reciclerView!!.adapter = mAdapter

        prepareMovieData()

    }

    override fun onResume() {
        super.onResume()
        Log.d("app:RecyclerView","onResume")
    }

    private fun prepareMovieData() {
        mAdapter!!.notifyDataSetChanged()
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.recycler_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        return when (item.itemId) {
            R.id.action_add_item -> {
                startActivity(Intent(this,AddMovieActivity::class.java))
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

}
