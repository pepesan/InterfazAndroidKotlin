package com.cursosdedesarrollo.interfazandroidkotlin

import android.support.v4.app.Fragment
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import kotlinx.android.synthetic.main.fragment_main.*
import android.arch.lifecycle.ViewModelProviders


/**
 * A placeholder fragment containing a simple view.
 */
class MainActivityFragment : Fragment() {


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_main, container, false)
    }

    private lateinit var mViewModel: DatoViewModel

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        tv.text="Hola Hola"
        mViewModel = ViewModelProviders.of(this).get(DatoViewModel::class.java)
        button.setOnClickListener({
            tv.text="Texto cambiado"
            mViewModel.dato="Dato Cambiado"
        })

        actualizaVista()
    }

    private fun actualizaVista() {
        vista.text=mViewModel.dato
    }
}
