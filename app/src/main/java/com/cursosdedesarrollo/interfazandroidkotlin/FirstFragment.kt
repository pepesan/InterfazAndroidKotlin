package com.cursosdedesarrollo.interfazandroidkotlin

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.content_listados.*

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class FirstFragment : Fragment() {
    private val datos: MutableList<String> = mutableListOf("uno", "dos", "Tres")

    private lateinit var adapter: ArrayAdapter<String>


    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_first, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        texto.visibility = View.GONE
        listado.visibility=View.VISIBLE


        listado.isTextFilterEnabled = true
        this.adapter = activity?.let { ArrayAdapter<String>(it, R.layout.item, datos) }!!
        listado.adapter= this.adapter
        listado.onItemClickListener = AdapterView.OnItemClickListener {
            parent, view, position, id ->
            datos.removeAt(position)
            adapter.notifyDataSetChanged()
        }
        view.findViewById<FloatingActionButton>(R.id.fab)?.setOnClickListener { _ ->
            addData()
        }
    }


    private fun addData() {
        datos.add("pepe")
        adapter.notifyDataSetChanged()
    }


}