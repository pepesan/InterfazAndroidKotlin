package com.cursosdedesarrollo.interfazandroidkotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.widget.Toolbar
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.activity_constraint_layout.*

class BookRecycleViewActivity : AppCompatActivity() {
    lateinit var bookList: MutableList<Book>
    private var bAdapter: BookAdapter? = null
    private var reciclerView: RecyclerView? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_book_recycle_view)

        bookList = (application as Aplicacion).bookList

        bAdapter = BookAdapter(bookList, this)
        val mLayoutManager = LinearLayoutManager(applicationContext)
        this.reciclerView = findViewById(R.id.book_rv)
        reciclerView!!.layoutManager = mLayoutManager
        reciclerView!!.itemAnimator = DefaultItemAnimator()
        reciclerView!!.adapter = bAdapter

        prepareBookData()
    }

    private fun prepareBookData() {
        bAdapter!!.notifyDataSetChanged()
    }
}