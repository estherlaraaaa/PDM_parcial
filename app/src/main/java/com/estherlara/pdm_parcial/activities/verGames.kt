package com.estherlara.pdm_parcial.activities

import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.estherlara.pdm_parcial.R
import com.estherlara.pdm_parcial.fragments.ListaFragment


class verGames : AppCompatActivity(), ListaFragment.OnFragmentInteractionListener {
    val listGame = ListaFragment()

    override fun onFragmentInteraction(uri: Uri) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.list_games)

        supportFragmentManager.beginTransaction().replace(R.id.ContenedorFragments, listGame).commit()


    }
}
