package com.estherlara.pdm_parcial.activities

import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.FrameLayout
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import com.estherlara.pdm_parcial.R
import com.estherlara.pdm_parcial.database.entities.Team
import com.example.designproyect.fragments.TeamFagment
import com.example.taller4.Interface.IComunicaFragments
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), TeamFagment.OnFragmentInteractionListener, IComunicaFragments {

    var listaFragment = TeamFagment()

    override fun sendTeam(
        nameTeam: String,
        pointsTeam: String,
        dateTeam: String,
        timeTeam: String) {

        val bundle  = Bundle()

        bundle.putString("Nombre equipo",nameTeam)
        bundle.putString("puntos",  pointsTeam)
        bundle.putString("fecha", dateTeam)
        bundle.putString("hora", timeTeam)

        listaFragment.arguments = bundle



        val fragmento : Fragment? = supportFragmentManager.findFragmentById(R.id.ContenedorFragments);
        if(findViewById<FrameLayout>(R.id.ContenedorFragments) == null){

            if(fragmento is TeamFagment) {
                val fragmento2: Fragment? = supportFragmentManager.findFragmentByTag("fragdetalle")
                supportFragmentManager.beginTransaction().remove(fragmento2!!).commit()

            }
            supportFragmentManager.beginTransaction().replace(R.id.ContenedorFragments,listaFragment, "fragdetalle").addToBackStack(null).commitAllowingStateLoss();

            Log.i("Aja:","Aja")

        }else{
            val bundle  = Bundle()

            bundle.putString("Nombre equipo",nameTeam)
            bundle.putString("puntos",  pointsTeam)
            bundle.putString("fecha", dateTeam)
            bundle.putString("hora", timeTeam)

            listaFragment.arguments = bundle
            supportFragmentManager.beginTransaction().replace(R.id.ContenedorFragments, listaFragment).addToBackStack(null).commit()

        }

    }

    override fun sendMatch(
        nameMatch: String,
        teamA: String,
        teamB: String,
        date: String,
        time: String,
        pointsTeamA: String,
        pointsTeamB: String,
        win: String
    ) {

    }


    override fun onFragmentInteraction(uri: Uri) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setInitialFragment()


    }

    private fun setInitialFragment(){
        supportFragmentManager.beginTransaction().replace(R.id.ContenedorFragments, TeamFagment()).commit()
    }


}

