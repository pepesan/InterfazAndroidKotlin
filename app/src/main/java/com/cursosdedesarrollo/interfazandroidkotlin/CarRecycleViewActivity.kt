package com.cursosdedesarrollo.interfazandroidkotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class CarRecycleViewActivity : AppCompatActivity() {
    lateinit var carList: MutableList<Car>
    var empty: TextView? = null
    var carRecycleView: RecyclerView? = null
    private var cAdapter: CarAdapter? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_car_recycle_view)
        carList= (application as? Aplicacion)!!.carList
        Log.d("app: CarRecycleView", "carList: $carList")
        empty= findViewById(R.id.empty)
        carRecycleView= findViewById(R.id.carReciclerView)
        cAdapter = CarAdapter(carList, this)
        val mLayoutManager = LinearLayoutManager(applicationContext)
        carRecycleView!!.layoutManager = mLayoutManager
        carRecycleView!!.itemAnimator = DefaultItemAnimator()
        carRecycleView!!.adapter = cAdapter
        if (carList.size>0){
            empty?.visibility= View.GONE
            carRecycleView?.visibility= View.VISIBLE
        }

    }
}