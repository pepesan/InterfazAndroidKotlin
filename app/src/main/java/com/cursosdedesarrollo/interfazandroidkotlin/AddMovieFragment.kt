package com.cursosdedesarrollo.interfazandroidkotlin

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import android.widget.Toast
import kotlinx.android.synthetic.main.content_add_movie.*


/**
 * A simple [Fragment] subclass.
 * Use the [AddMovieFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class AddMovieFragment : Fragment() {


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_add_movie, container, false)
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.add_movie_menu, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        return when (item.itemId) {
            R.id.action_save_movie -> {
                //startActivity(Intent(this,AddMovieActivity::class.java))
                saveMovie()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }
    private fun saveMovie() {
        if(titleText.text.toString()!="") {
            val movie = Movie(titleText.text.toString(), genreText.text.toString(), yearText.text.toString())
            (activity?.application as Aplicacion).addData(movie)
            findNavController().navigate(R.id.action_addMovieFragment_to_MovieFragment)
        }else{

            //Toast.makeText(this,"El Campo Title no puede estar vacío", Toast.LENGTH_LONG).show()
        }
    }
}