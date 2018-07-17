package com.cursosdedesarrollo.interfazandroidkotlin

import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Toast

import kotlinx.android.synthetic.main.activity_listados.*
import kotlinx.android.synthetic.main.content_formulario.*
import kotlinx.android.synthetic.main.content_listados.*

class ListadosActivity : AppCompatActivity() {

    private val datos = mutableListOf("uno", "dos")

    private lateinit var adapter: ArrayAdapter<String>

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
        adapter = ArrayAdapter<String>(this, R.layout.item, datos)
        listado.setTextFilterEnabled(true)
        listado.setAdapter(adapter)
        listado.setOnItemClickListener(AdapterView.OnItemClickListener {
            parent, view, position, id ->
            Toast.makeText(this@ListadosActivity, datos[position], Toast.LENGTH_LONG).show()
            datos.removeAt(position)
            adapter.notifyDataSetChanged()
        })
    }
    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.listado_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        return when (item.itemId) {
            R.id.action_add_listado -> {
                datos.add("pepe")
                adapter.notifyDataSetChanged()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

}
