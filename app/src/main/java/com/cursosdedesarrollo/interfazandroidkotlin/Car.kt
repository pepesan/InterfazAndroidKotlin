package com.cursosdedesarrollo.interfazandroidkotlin

class Car(marca: String = "", modelo: String = "") {
    var marca: String? = marca
    var modelo: String? = modelo

    override fun toString(): String {
        return "marca: $marca modelo: $modelo"
    }
}