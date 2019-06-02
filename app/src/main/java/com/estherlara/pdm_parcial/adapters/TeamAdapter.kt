package com.estherlara.pdm_parcial.adapters

import android.app.Activity
import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.fragment.app.FragmentActivity
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.RecyclerView
import com.estherlara.pdm_parcial.R
import com.estherlara.pdm_parcial.database.daos.TeamDAO
import com.estherlara.pdm_parcial.database.entities.Team
import com.estherlara.pdm_parcial.viewModel.ViewModel


class PartidosAdapter internal constructor(context : Context): RecyclerView.Adapter<PartidosAdapter.TeamViewHolder>(){
    private val inflater : LayoutInflater = LayoutInflater.from(context)
    private var team = emptyList<Team>()


    class TeamViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val nameTeam : TextView = itemView.findViewById(R.id.tv_nameTeam)
        val pointsTeam : TextView = itemView.findViewById(R.id.tv_pointsTeam)
        val dateTeam : TextView = itemView.findViewById(R.id.tv_dateTeam)
        val timeTeam : TextView = itemView.findViewById(R.id.tv_timeTeam)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PartidosAdapter.TeamViewHolder {
        val itemView = inflater.inflate(R.layout.item_list_team, parent, false)
        return TeamViewHolder(itemView)
    }

    override fun getItemCount(): Int = team.size

    override fun onBindViewHolder(holder: PartidosAdapter.TeamViewHolder, position: Int) {
        val current = team[position]
        holder.nameTeam.text = current.name.toString()
        holder.pointsTeam.text = current.points.toString()
        holder.dateTeam.text = current.date.toString()
        holder.timeTeam.text = current.time.toString()
    }

    internal fun setTeam(teams: List<Team>) {
        this.team = teams
        notifyDataSetChanged()
    }


}