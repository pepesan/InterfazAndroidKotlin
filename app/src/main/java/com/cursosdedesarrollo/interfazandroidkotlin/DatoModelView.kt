package com.cursosdedesarrollo.interfazandroidkotlin

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel


class DatoViewModel : ViewModel {
    // Tracks the score for Team A
    var dato = "Dato en ModelView"
    val datoObservable= MutableLiveData<String>()
    constructor(){
        this.dato=""
        this.datoObservable.value="Dato inicial"
    }

    constructor(dato:String="",datoObservable:String=""): super(){
        this.dato=dato
        this.datoObservable.value=datoObservable
    }



}