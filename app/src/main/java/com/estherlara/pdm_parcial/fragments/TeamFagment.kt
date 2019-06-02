package com.example.designproyect.fragments


import android.app.Activity
import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.estherlara.pdm_parcial.R
import com.estherlara.pdm_parcial.activities.newTeamActivity
import com.estherlara.pdm_parcial.adapters.TeamAdapter
import com.estherlara.pdm_parcial.viewModel.ViewModel
import com.example.taller4.Interface.IComunicaFragments


//mostrara el feed de partidos de team

private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

class TeamFagment : Fragment() {

    private var param1: String? = null
    private var param2: String? = null
    private var listener: OnFragmentInteractionListener? = null

    var actividad  = Activity()
    var iCOmunica = object : IComunicaFragments {
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

        override fun sendTeam(
            nameTeam: String,
            pointsTeam: String,
            dateTeam: String,
            timeTeam: String) {
            TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val vista = inflater.inflate(R.layout.fragment_team, container, false)

        val viewmodel = ViewModelProviders.of(this).get(ViewModel::class.java)
        val recyclerView = vista.findViewById<RecyclerView>(R.id.rv_team)
        val showTeam = vista.findViewById<Button>(R.id.btn_team)
        val showMatch = vista.findViewById<Button>(R.id.btn_match)
        val showGame = vista.findViewById<Button>(R.id.btn_game)
        val add = vista.findViewById<Button>(R.id.btn_addTeam)

        val adapter = context?.let { TeamAdapter(it) }
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(context)

        viewmodel.allTeam.observe(this, Observer { team->
            team?.let { adapter?.setOnClickListener(object : View.OnClickListener{
                override fun onClick(v: View) {

                    iCOmunica.sendTeam(team.get(recyclerView.getChildAdapterPosition(v)).name,
                        team.get(recyclerView.getChildAdapterPosition(v)).points,
                        team.get(recyclerView.getChildAdapterPosition(v)).date,
                        team.get(recyclerView.getChildAdapterPosition(v)).time)

                }})}
        })

        viewmodel.allTeam.observe(this, Observer { books->
            books?.let {


                adapter?.setTeam(books)

            }
        })

        showMatch.setOnClickListener{
            val intent = Intent(context, com.estherlara.pdm_parcial.activities.showMatch::class.java)
            startActivity(intent)
        }

        add.setOnClickListener {
            val intent = Intent(context, newTeamActivity::class.java)
            startActivity(intent)
        }

        return vista
    }

    fun onButtonPressed(uri: Uri) {
        listener?.onFragmentInteraction(uri)
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        //Interface
        if(context is Activity){
            this.actividad = context as Activity
            iCOmunica = this.actividad as IComunicaFragments
        }

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
        fun newInstance() =
            TeamFagment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}