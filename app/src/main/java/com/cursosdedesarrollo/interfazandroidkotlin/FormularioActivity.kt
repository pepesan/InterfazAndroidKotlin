package com.cursosdedesarrollo.interfazandroidkotlin


import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.view.KeyEvent
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.*

import kotlinx.android.synthetic.main.activity_formulario.*
import kotlinx.android.synthetic.main.content_formulario.*

class FormularioActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_formulario)
        setSupportActionBar(toolbar)

        fab.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                    .setAction("Action", null).show()
        }
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        setUpViews()
    }

    private fun setUpViews() {
        // inicializamos los objetos de la vista
        radio_red.isChecked = true
        Toast.makeText(this,
                "Hasta que no marques la checkbox no podrás salvar",
                Toast.LENGTH_LONG).show()

        volver.setOnClickListener({
            finish()
        })
        // cambiamos los comportamientos que no son click
        edittext.setOnKeyListener(View.OnKeyListener { v, keyCode, event ->
            // If the event is a key-down event on the "enter" button
            if (event.action == KeyEvent.ACTION_DOWN && keyCode == KeyEvent.KEYCODE_ENTER) {
                // Perform action on key press
                Toast.makeText(this@FormularioActivity,
                        edittext.text, Toast.LENGTH_SHORT).show()
                return@OnKeyListener true
            }
            false
        })

        val i = RatingBar.OnRatingBarChangeListener { ratingBar, rating, fromUser ->
            Toast.makeText(
                    this@FormularioActivity,
                    "New Rating: $rating",
                    Toast.LENGTH_SHORT).show()
        }
        ratingbar.onRatingBarChangeListener = i


    }
    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.form_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        return when (item.itemId) {
            R.id.action_add -> {
                sendClick(send)
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    // cambio de comportamiento del boton con imagen
    fun ImageClick(v: View) {
        // Perform action on clicks
        val t = Toast.makeText(this, "Beep Bop", Toast.LENGTH_SHORT)
        t.show()
    }

    // cambio de comportamiento del boton volver
    fun volver(v: View) {
        // Perform action on clicks
        finish()
    }

    // cambio de comportamiento de la checkbox
    fun checkBoxClick(v: View) {
        var text = ""
        // Perform action on clicks, depending on whether it's now checked
        // CheckBox cb=(CheckBox) v;
        if (checkbox.isChecked()) {
            text = "Selected"
            send.setEnabled(true)
            Toast.makeText(this,
                    "Ya puedes Salvar",
                    Toast.LENGTH_LONG).show()
        } else {
            send.setEnabled(false)
            Toast.makeText(this,
                    "Hasta que no marques la casilla no podrás salvar",
                    Toast.LENGTH_LONG).show()
            text = "Not selected"

        }
        Toast.makeText(this, text, Toast.LENGTH_SHORT).show()
    }

    // cambio de comportamiento de los botones de radio
    fun radioClick(v: View) {
        // Perform action on clicks
        val rb = v as? RadioButton
        if(rb?.id == R.id.radio_red){

        }
        val cadenaId = "id"
        Toast.makeText(this, "$cadenaId: ${rb?.id}, Text: ${rb?.text}", Toast.LENGTH_SHORT).show()
    }

    // cambio de comportamiento del toggle
    fun toggleClick(v: View) {
        //ToggleButton tb=(ToggleButton)v;
        // Perform action on clicks
        if (togglebutton.isChecked()) {
            //if (tb.isChecked()) {
            Toast.makeText(this@FormularioActivity, "Checked",
                    Toast.LENGTH_SHORT).show()
        } else {
            Toast.makeText(this@FormularioActivity, "Not checked",
                    Toast.LENGTH_SHORT).show()
        }
    }

    // cambio de comportamiento del boton enviar
    fun sendClick(v: View) {
        // Perform action on clicks
        var allText = "campo:" + edittext.text
        allText = allText + ":checkbox:"
        if (checkbox.isChecked()) {
            allText = allText + "Checked:"
        } else {
            allText = allText + "Not Checked:"

        }
        allText = allText + ":toggle:"
        if (togglebutton.isChecked()) {
            allText = allText + "Checked:"
        } else {
            allText = allText + "Not Checked:"

        }
        allText = allText + "radios:rojo:"
        var redtext = ""
        if (radio_red.isChecked()) {
            redtext = "pulsado:"
        } else {
            redtext = "no pulsado:"
        }
        allText = allText + redtext
        allText = allText + "azul"
        var bluetext = ""
        if (radio_blue.isChecked()) {
            bluetext = "pulsado:"
        } else {
            bluetext = "no pulsado:"
        }
        allText = allText + bluetext
        allText = allText + "rating:"
        val f = ratingbar.rating
        allText = allText + ratingbar.rating + ":"

        Log.d("app", allText)
        Toast.makeText(this, allText, Toast.LENGTH_LONG).show()
    }

}
