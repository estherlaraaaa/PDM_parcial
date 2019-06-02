package com.estherlara.pdm_parcial.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.estherlara.pdm_parcial.R
import com.estherlara.pdm_parcial.database.entities.Match

class MatchAdapter internal constructor(context: Context) : RecyclerView.Adapter<MatchAdapter.MatchViewHolder>() {

    private val inflater: LayoutInflater = LayoutInflater.from(context)
    private var match = emptyList<Match>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MatchViewHolder {
        val itemView = inflater.inflate(R.layout.item_list_match, parent, false)
        return MatchViewHolder(itemView)
    }

    override fun getItemCount() = match.size

    override fun onBindViewHolder(holder: MatchViewHolder, position: Int) {
        val current = match[position]
        holder.nameMatch.text = current.nameMatch
        holder.teamA.text = current.teamA
        holder.teamB.text = current.teamB
        holder.pointsTeamA.text = current.pointTeamA
        holder.pointsTeamB.text = current.pointTeamB
        holder.dateMatch.text = current.date
        holder.timeMatch.text = current.time

    }
    internal fun setMatch(match: List<Match>) {
        this.match = match
        notifyDataSetChanged()
    }

    class MatchViewHolder (itemView: View) : RecyclerView.ViewHolder(itemView){
        val nameMatch: TextView = itemView.findViewById(R.id.tv_nameMatch)
        val teamA: TextView = itemView.findViewById(R.id.tv_nameTeamAMatch)
        val teamB: TextView = itemView.findViewById(R.id.tv_nameTeamBMatch)
        val pointsTeamA: TextView = itemView.findViewById(R.id.tv_pointsTeamAMatch)
        val pointsTeamB: TextView = itemView.findViewById(R.id.tv_pointsTeamBMatch)
        val dateMatch: TextView = itemView.findViewById(R.id.tv_dateMatch)
        val timeMatch: TextView = itemView.findViewById(R.id.tv_timeMatch)



    }


}