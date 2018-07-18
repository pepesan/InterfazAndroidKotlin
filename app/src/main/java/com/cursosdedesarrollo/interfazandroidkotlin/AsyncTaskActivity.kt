package com.cursosdedesarrollo.interfazandroidkotlin

import android.content.Intent
import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.view.Menu
import android.view.MenuItem

import kotlinx.android.synthetic.main.activity_async_task.*
import android.R.string.cancel
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.os.AsyncTask
import android.view.View
import android.widget.ImageView
import android.widget.ProgressBar
import kotlinx.android.synthetic.main.content_async_task.*
import java.io.IOException
import java.net.URL
import com.cursosdedesarrollo.interfazandroidkotlin.AsyncTaskActivity.MiTarea




class AsyncTaskActivity : AppCompatActivity() {
    private var downloadBitmap: Bitmap? = null
    //Recordar dar permiso de acceso a internet para que funcione
    private val url = "https://i1.wp.com/cursosdedesarrollo.com/wp-content/uploads/2017/05/final-architecture.png"
    private var tarea: MiTarea? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_async_task)
        setSupportActionBar(toolbar)

        fab.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                    .setAction("Action", null).show()
        }
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        setUpViews()
    }

    fun setUpViews() {
        // get the latest imageView after restart of the application

        // Did we already download the image?
        if (downloadBitmap != null) {
            imageView1.setImageBitmap(downloadBitmap)
        }
    }
    fun resetPicture(view: View) {
        resetAction()
    }


    fun downloadPicture(view: View) {
        downloadAction()
    }
    inner class MiTarea : AsyncTask<String, Int, Bitmap>() {
        override fun onPreExecute() {
            cargando.setVisibility(View.VISIBLE)
            imageView1.setVisibility(View.GONE)
            //descarga.setEnabled(false);
        }

        fun onProgressUpdate(vararg progress: Int) {
            Log.d("App", "Progreso" + progress[0])
        }

        override fun doInBackground(vararg params: String): Bitmap? {
            for (i in 0..99) {
                publishProgress(i)
            }
            try {
                Thread.sleep(2000)
            } catch (e: InterruptedException) {
                e.printStackTrace()
            }

            try {
                val imageURL = URL(params[0])

                downloadBitmap = BitmapFactory.decodeStream(imageURL.openStream())

            } catch (e: IOException) {
                // TODO Auto-generated catch block
                e.printStackTrace()
            }

            return downloadBitmap
        }

        override fun onPostExecute(bm: Bitmap) {

            imageView1.setImageBitmap(bm)
            cargando.setVisibility(View.GONE)
            imageView1.setVisibility(View.VISIBLE)
            //dialog.dismiss();

            //descarga.setEnabled(true);
        }

    }
    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.async_menu, menu)
        return true
    }



    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        return when (item.itemId) {
            R.id.action_download -> {
                Log.d("Boton Descargar", "Pulsado");
                downloadAction();
                true
            }
            R.id.action_reset -> {
                Log.d("Boton Reset", "Pulsado");
                resetAction();
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    fun downloadAction() {
        tarea = MiTarea()
        tarea!!.execute(url)
    }

    fun resetAction() {
        if (downloadBitmap != null) {
            downloadBitmap = null
        }
        tarea!!.cancel(true)
        cargando.setVisibility(View.GONE)
        imageView1.setVisibility(View.VISIBLE)
        imageView1.setImageResource(R.mipmap.ic_launcher)
    }

}
