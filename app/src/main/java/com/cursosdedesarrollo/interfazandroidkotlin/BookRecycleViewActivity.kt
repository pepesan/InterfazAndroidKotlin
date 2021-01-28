package com.cursosdedesarrollo.interfazandroidkotlin

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.ActionBar
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_constraint_layout.*
import kotlinx.android.synthetic.main.activity_listados.*

class BookRecycleViewActivity : AppCompatActivity() {
    lateinit var bookList: MutableList<Book>
    private var bAdapter: BookAdapter? = null
    private var reciclerView: RecyclerView? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_book_recycle_view)
        // calling the action bar
        val actionBar: ActionBar? = supportActionBar

        // showing the back button in action bar
        actionBar?.setHomeAsUpIndicator(R.drawable.ic_add_white_24dp);
        actionBar?.setDisplayHomeAsUpEnabled(true)
        bookList = (application as Aplicacion).bookList

        bAdapter = BookAdapter(bookList, this)
        val mLayoutManager = LinearLayoutManager(applicationContext)
        this.reciclerView = findViewById(R.id.book_rv)
        reciclerView!!.layoutManager = mLayoutManager
        reciclerView!!.itemAnimator = DefaultItemAnimator()
        reciclerView!!.adapter = bAdapter

        prepareBookData()
    }

    override fun onResume() {
        super.onResume()
        bAdapter!!.notifyDataSetChanged()
        Log.d("app:RecyclerView", "onResume")
    }

    private fun prepareBookData() {
        bAdapter!!.notifyDataSetChanged()
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
                startActivity(Intent(this, AddMovieActivity::class.java))
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }
}