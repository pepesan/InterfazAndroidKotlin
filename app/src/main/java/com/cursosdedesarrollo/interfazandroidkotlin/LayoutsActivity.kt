package com.cursosdedesarrollo.interfazandroidkotlin

import android.content.Intent
import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import android.view.View

import kotlinx.android.synthetic.main.activity_layouts.*

class LayoutsActivity : MiActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_layouts)
        setSupportActionBar(toolbar)

        fab.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                    .setAction("Action", null).show()
        }
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }

    fun goLinear(view: View):Unit{
        val intent= Intent(this,LinearLayoutActivity::class.java)
        startActivity(intent)
    }
    fun goRelative(view: View):Unit{
        val intent= Intent(this,RelativeLayoutActivity::class.java)
        startActivity(intent)
    }
    fun goConstraint(view: View):Unit{
        val intent= Intent(this,ConstraintLayoutActivity::class.java)
        startActivity(intent)
    }



}
