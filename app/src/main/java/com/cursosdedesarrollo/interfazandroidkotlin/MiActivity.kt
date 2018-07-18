package com.cursosdedesarrollo.interfazandroidkotlin

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem

import kotlinx.android.synthetic.main.activity_main.*

@SuppressLint("Registered")
open class MiActivity : AppCompatActivity() {


    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        return when (item.itemId) {
            R.id.action_layouts -> {
                var intent = Intent(this,LayoutsActivity::class.java)
                startActivity(intent)
                true
            }
            R.id.action_listados -> {
                var intent = Intent(this,ListadosActivity::class.java)
                startActivity(intent)
                true
            }
            R.id.action_formulario -> {
                var intent = Intent(this,FormularioActivity::class.java)
                startActivity(intent)
                true
            }
            R.id.action_show_recyclerview -> {
                val intent = Intent(this,RecyclerViewActivity::class.java)
                startActivity(intent)
                true
            }
            R.id.action_alert_dialog -> {
                val intent = Intent(this,AlertDialogActivity::class.java)
                startActivity(intent)
                true
            }
            R.id.action_async_task -> {
                val intent = Intent(this,AsyncTaskActivity::class.java)
                startActivity(intent)
                true
            }
            R.id.action_notificaciones -> {
                val intent = Intent(this,NotificacionesActivity::class.java)
                startActivity(intent)
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }
}
