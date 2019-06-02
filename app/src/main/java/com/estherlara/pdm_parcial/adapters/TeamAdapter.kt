package com.estherlara.pdm_parcial.adapters

import android.app.Activity
import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.FragmentActivity
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.RecyclerView
import com.estherlara.pdm_parcial.R
import com.estherlara.pdm_parcial.database.daos.TeamDAO
import com.estherlara.pdm_parcial.database.entities.Team
import com.estherlara.pdm_parcial.viewModel.ViewModel


class TeamAdapter internal constructor(context: Context) : RecyclerView.Adapter<TeamAdapter.TeamViewHolder>() , View.OnClickListener {

    private val inflater: LayoutInflater = LayoutInflater.from(context)
    private var team = emptyList<Team>() //
    private var listener: View.OnClickListener ?= null
    private var listenerBoton: View.OnClickListener ?= null

    inner class TeamViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val nameTeam: TextView = itemView.findViewById(R.id.et_nameTeam)
        val pointsTeam: TextView = itemView.findViewById(R.id.et_pointsTeam)
        val dateTeam: TextView = itemView.findViewById(R.id.et_dateTeam)
        val timeTeam: TextView = itemView.findViewById(R.id.et_timeTeam)

    }



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TeamViewHolder {
        val itemView = inflater.inflate(R.layout.item_list_team, parent, false)
        itemView.setOnClickListener(listener)

        return TeamViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: TeamViewHolder, position: Int) {


        val current = team[position]
        holder.nameTeam.text = current.name
        holder.pointsTeam.text = current.points
        holder.dateTeam.text = current.date
        holder.timeTeam.text = current.time

    }

    internal fun setTeam(team: List<Team>) {
        this.team = team
        notifyDataSetChanged()
    }

    override fun getItemCount() = team.size

    fun setOnClickListenerBoton(listener : View.OnClickListener){
        this.listenerBoton = listener

    }

    fun setOnClickListener(listener: View.OnClickListener){
        this.listener = listener

    }


    override fun onClick(v: View?) {
        if(listener !=null){
            listener?.onClick(v)
        }
        if(listenerBoton != null){
            listenerBoton?.onClick(v)
        }
    }

}