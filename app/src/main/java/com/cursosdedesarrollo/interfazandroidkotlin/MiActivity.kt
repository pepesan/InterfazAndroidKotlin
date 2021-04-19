package com.cursosdedesarrollo.interfazandroidkotlin

import android.content.Intent
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity


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
            R.id.action_listado_fragment -> {
                var intent = Intent(this,ListadoFragmentActivity::class.java)
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
            R.id.action_book_recyclerview -> {
                val intent = Intent(this,BookRecycleViewActivity::class.java)
                startActivity(intent)
                true
            }
            R.id.action_car_recyclerview -> {
                val intent = Intent(this,CarRecycleViewActivity::class.java)
                startActivity(intent)
                true
            }
            R.id.action_show_recyclerview_fragment -> {
                val intent = Intent(this,RecicleViewFragmentActivity::class.java)
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
            R.id.action_fragment_notificaciones -> {
                val intent = Intent(this,NotificationsFragmentActivity::class.java)
                startActivity(intent)
                true
            }
            R.id.action_coroutine -> {
                val intent = Intent(this,CoroutineActivity::class.java)
                startActivity(intent)
                true
            }
            R.id.action_workmanager -> {
                val intent = Intent(this, WorkManagerActivity::class.java)
                startActivity(intent)
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }
}
