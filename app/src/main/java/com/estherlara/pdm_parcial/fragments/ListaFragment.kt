package com.estherlara.pdm_parcial.fragments

import android.content.Context
import android.net.Uri
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.estherlara.pdm_parcial.R
import com.estherlara.pdm_parcial.adapters.GameAdapter
import com.estherlara.pdm_parcial.viewModel.ViewModel



private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

class ListaFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null
    private var listener: OnFragmentInteractionListener? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }


    //SOLO ESTA FUNCION TOQUE YO
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val vista = inflater.inflate(R.layout.fragment_list_games, container, false)

        val viewModel = ViewModelProviders.of(this).get(ViewModel::class.java)
        val recyclerView = vista.findViewById<RecyclerView>(R.id.rv_games)

        val adapter = context?.let { GameAdapter(it) }
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(context) as RecyclerView.LayoutManager?

        viewModel.allGames.observe(this, Observer { partidos->
            partidos?.let {
                for(repo in partidos){
                    Log.d("Id",repo.Id_Game.toString())
                }
                adapter?.setGames(partidos)
            }
        })


        return vista
    }


    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is OnFragmentInteractionListener) {
            listener = context
        } else {
            throw RuntimeException(context.toString() + " must implement OnFragmentInteractionListener")
        }
    }

    override fun onDetach() {
        super.onDetach()
        listener = null
    }

    interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        fun onFragmentInteraction(uri: Uri)
    }

    companion object {
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            ListaFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}
