package com.cursosdedesarrollo.interfazandroidkotlin

import android.content.DialogInterface
import android.graphics.Color
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import com.google.android.material.snackbar.Snackbar

import kotlinx.android.synthetic.main.activity_alert_dialog.*
import kotlinx.android.synthetic.main.content_alert_dialog.*


class AlertDialogActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_alert_dialog)
        setSupportActionBar(toolbar as Toolbar?)

        fab.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                    .setAction("Action", null).show()
        }
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }

    fun showAlert(v:View){
        // Initialize a new instance of
        val builder = AlertDialog.Builder(this)

        // Set the alert dialog title
        builder.setTitle("App background color")

        // Display a message on alert dialog
        builder.setMessage("Are you want to set the app background color to RED?")

        // Set a positive button and its click listener on alert dialog
        builder.setPositiveButton("YES"){dialog, which ->
            // Do something when user press the positive button
            Toast.makeText(applicationContext,"Ok, we change the app background.",Toast.LENGTH_SHORT).show()

            // Change the app background color
            cs_alert.setBackgroundColor(Color.RED)
        }


        // Display a negative button on alert dialog
        builder.setNegativeButton("No"){dialog,which ->
            Toast.makeText(applicationContext,"You are not agree.",Toast.LENGTH_SHORT).show()
        }


        // Display a neutral button on alert dialog
        builder.setNeutralButton("Cancel"){_,_ ->
            Toast.makeText(applicationContext,"You cancelled the dialog.",Toast.LENGTH_SHORT).show()
        }

        // Finally, make the alert dialog using builder
        val dialog: AlertDialog = builder.create()

        // Display the alert dialog on app interface
        dialog.show()
    }

}
