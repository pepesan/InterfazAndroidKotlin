package com.cursosdedesarrollo.interfazandroidkotlin

import android.content.Intent
import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast

import kotlinx.android.synthetic.main.activity_add_movie.*
import kotlinx.android.synthetic.main.content_add_movie.*
import kotlinx.android.synthetic.main.movies_row.*

class AddMovieActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_movie)
        setSupportActionBar(toolbar)

        fab.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                    .setAction("Action", null).show()
        }
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }
    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.add_movie_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        return when (item.itemId) {
            R.id.action_save_movie -> {
                //startActivity(Intent(this,AddMovieActivity::class.java))
                saveMovie()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    private fun saveMovie() {
        if(titleText.text.toString()!="") {
            val movie = Movie(titleText.text.toString(), genreText.text.toString(), yearText.text.toString())
            (application as Aplicacion).addData(movie)
            finish()
        }else{
            Toast.makeText(this,"El Campo Title no puede estar vacío",Toast.LENGTH_LONG).show()
        }
    }

}
