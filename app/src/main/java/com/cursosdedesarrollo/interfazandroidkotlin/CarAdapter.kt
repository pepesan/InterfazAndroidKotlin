package com.cursosdedesarrollo.interfazandroidkotlin

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView


class CarAdapter(private val carList: List<Car>, val context: Context) : RecyclerView.Adapter<CarAdapter.MyViewHolder>(){

    inner class MyViewHolder(view: View) : RecyclerView.ViewHolder(view) , View.OnClickListener{
        private var mItem: Car? = null
        var marca: TextView
        var modelo: TextView

        init {
            marca = view.findViewById<View>(R.id.marca) as TextView
            modelo = view.findViewById<View>(R.id.modelo) as TextView
            view.setOnClickListener(this);

        }

        fun setItem(car: Car) {
            mItem = car
            marca.text = car.marca
            modelo.text = car.modelo
        }

        override fun onClick(view: View) {
            val intent = Intent(context ,MovieDetailActivity::class.java)
            intent.putExtra("title", mItem!!.modelo)
            (context as Activity).startActivity(intent)
        }

    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView = LayoutInflater.from(parent.context)
                .inflate(R.layout.cars_row, parent, false)

        return MyViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val car = carList[position]
        holder.setItem(car)
    }

    override fun getItemCount(): Int {
        return carList.size
    }
}