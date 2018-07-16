package com.cursosdedesarrollo.interfazandroidkotlin

import android.arch.lifecycle.Observer
import android.support.v4.app.Fragment
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import kotlinx.android.synthetic.main.fragment_main.*
import android.arch.lifecycle.ViewModelProviders
import android.util.Log


/**
 * A placeholder fragment containing a simple view.
 */
class MainActivityFragment : Fragment() {

    var numero =0

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_main, container, false)
    }

    private var mViewModel: DatoViewModel= DatoViewModel()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        tv.text="Hola Hola"
        mViewModel = ViewModelProviders.of(this).get(DatoViewModel::class.java)
        button.setOnClickListener({
            tv.text="Texto cambiado"
            mViewModel.dato="Dato Cambiado"
            numero++
            mViewModel.datoObservable.value="DatoObservable Cambiado $numero"
        })
        actualizaVista()
        mViewModel.datoObservable.observe(this, Observer {cadena ->
            Log.d("app:","Valor: $cadena")
            vista.text=cadena
        })
    }

    private fun actualizaVista() {
        vista.text=mViewModel.dato
    }
}
