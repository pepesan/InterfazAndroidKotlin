package com.cursosdedesarrollo.interfazandroidkotlin

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView


class BookAdapter(private val bookList: List<Book>, val context: Context) : RecyclerView.Adapter<BookAdapter.MyViewHolder>(){

    inner class MyViewHolder(view: View) : RecyclerView.ViewHolder(view) , View.OnClickListener{
        private var bItem: Book? = null
        var title: TextView
        var pages: TextView
        var author: TextView

        init {
            title = view.findViewById<View>(R.id.title) as TextView
            author = view.findViewById<View>(R.id.author) as TextView
            pages = view.findViewById<View>(R.id.pages) as TextView
            view.setOnClickListener(this);

        }

        fun setItem(book: Book) {
            bItem = book
            title.text = book.title
            author.text = book.author
            pages.text = book.pages
        }

        override fun onClick(view: View) {
            val intent = Intent(context ,MovieDetailActivity::class.java)
            intent.putExtra("title", bItem!!.title)
            (context as Activity).startActivity(intent)
        }

    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView = LayoutInflater.from(parent.context)
                .inflate(R.layout.book_row, parent, false)

        return MyViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val book = bookList[position]
        holder.setItem(book)
    }

    override fun getItemCount(): Int {
        return bookList.size
    }
}