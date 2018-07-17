package com.cursosdedesarrollo.interfazandroidkotlin

import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Toast

import kotlinx.android.synthetic.main.activity_listados.*
import kotlinx.android.synthetic.main.content_listados.*

class ListadosActivity : AppCompatActivity() {

    private val datos = arrayOf("uno", "dos")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_listados)
        setSupportActionBar(toolbar)

        fab.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                    .setAction("Action", null).show()
        }
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        texto.setVisibility(View.GONE)
        listado.visibility=View.VISIBLE
        val adapter = ArrayAdapter<String>(this, R.layout.item, datos)
        listado.setTextFilterEnabled(true)
        listado.setAdapter(adapter)
        listado.setOnItemClickListener(AdapterView.OnItemClickListener {
            parent, view, position, id ->
            Toast.makeText(this@ListadosActivity, datos[position], Toast.LENGTH_LONG).show()
        })
    }

}
