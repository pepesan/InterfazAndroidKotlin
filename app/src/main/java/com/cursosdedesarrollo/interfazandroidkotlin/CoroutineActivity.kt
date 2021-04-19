package com.cursosdedesarrollo.interfazandroidkotlin

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class CoroutineActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_coroutine)
        setSupportActionBar(findViewById(R.id.toolbar))

    }
}