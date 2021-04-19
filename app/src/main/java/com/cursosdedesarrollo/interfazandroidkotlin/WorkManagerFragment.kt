package com.cursosdedesarrollo.interfazandroidkotlin

import android.content.Context
import android.content.ContextWrapper
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.navigation.fragment.findNavController
import androidx.work.*
import com.google.android.material.button.MaterialButton
import com.google.android.material.textview.MaterialTextView
import kotlinx.android.synthetic.main.fragment_workmanager.*
import kotlinx.coroutines.*
import java.io.File
import java.io.FileOutputStream
import java.io.IOException
import java.io.OutputStream
import java.net.URL
import java.util.*

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class WorkManagerFragment : Fragment() {
    var tvDownload: TextView? = null
    var button: Button? = null
    var progressBar: ProgressBar? = null
    var imageView : ImageView? = null
    var tvSaved: MaterialTextView? = null

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_workmanager, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val context = this

        // url of image to download
        val urlImage: URL = URL("https://images.pexels.com/photos/730344/" +
                "pexels-photo-730344.jpeg?" +
                "auto=compress&cs=tinysrgb&dpr=2&h=750&w=1260")
        tvDownload = view.findViewById(R.id.tvDownload)
        button = view.findViewById(R.id.button)
        progressBar = view.findViewById(R.id.progressBar)
        imageView = view.findViewById(R.id.imageView)
        tvSaved = view.findViewById(R.id.tvSaved)
        // show image url in text view
        tvDownload?.text = urlImage.toString()


        button?.setOnClickListener {
            it.isEnabled = false // disable button
            progressBar?.visibility = View.VISIBLE

            // async task to get / download bitmap from url
            val result: Deferred<Bitmap?> = GlobalScope.async {
                urlImage.toBitmap()
            }

            GlobalScope.launch(Dispatchers.Main) {
                // get the downloaded bitmap
                val bitmap : Bitmap? = result.await()

                // if downloaded then saved it to internal storage
                bitmap?.apply {
                    // get saved bitmap internal storage uri
                    val savedUri : Uri? = saveToInternalStorage(requireContext())

                    // display saved bitmap to image view from internal storage
                    imageView?.setImageURI(savedUri)

                    // show bitmap saved uri in text view
                    tvSaved?.text = savedUri.toString()
                }

                it.isEnabled = true // enable button
                progressBar?.visibility = View.INVISIBLE
            }
        }
    }
    // extension function to get / download bitmap from url
    fun URL.toBitmap(): Bitmap?{
        return try {
            BitmapFactory.decodeStream(openStream())
        }catch (e: IOException){
            null
        }
    }


    // extension function to save an image to internal storage
    fun Bitmap.saveToInternalStorage(context : Context):Uri?{
        // get the context wrapper instance
        val wrapper = ContextWrapper(context)

        // initializing a new file
        // bellow line return a directory in internal storage
        var file = wrapper.getDir("images", Context.MODE_PRIVATE)

        // create a file to save the image
        file = File(file, "${UUID.randomUUID()}.jpg")

        return try {
            // get the file output stream
            val stream: OutputStream = FileOutputStream(file)

            // compress bitmap
            compress(Bitmap.CompressFormat.JPEG, 100, stream)

            // flush the stream
            stream.flush()

            // close stream
            stream.close()

            // return the saved image uri
            Uri.parse(file.absolutePath)
        } catch (e: IOException){ // catch the exception
            e.printStackTrace()
            null
        }

    }
}