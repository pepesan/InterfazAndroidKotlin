package com.cursosdedesarrollo.interfazandroidkotlin


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import kotlinx.android.synthetic.main.fragment_main.*
import android.util.Log
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders


/**
 * A placeholder fragment containing a simple view.
 */
class MainActivityFragment : Fragment() {

    var numero =0

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_main, container, false)
    }

    lateinit var mViewModel: DatoViewModel

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        tv.text="Hola Hola"
        mViewModel = ViewModelProviders.of(this).get(DatoViewModel::class.java)
        if(mViewModel.dato == ""){
            mViewModel.dato="Dato Cambiado"
        }
        tv.text=mViewModel.dato
        button.setOnClickListener({
            mViewModel.dato="Dato Cambiado2"
            tv.text=mViewModel.dato
            numero++
            mViewModel.datoObservable.value="DatoObservable Cambiado $numero"
        })
        actualizaVista()
        mViewModel.datoObservable.observe(viewLifecycleOwner, Observer {cadena ->
            Log.d("app:","Valor: $cadena")
            vista.text=cadena
        })
    }

    private fun actualizaVista() {
        vista.text=mViewModel.dato
    }
}
