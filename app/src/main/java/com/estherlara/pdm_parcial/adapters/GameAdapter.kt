package com.estherlara.pdm_parcial.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.estherlara.pdm_parcial.R
import com.estherlara.pdm_parcial.database.entities.Game


class GameAdapter internal constructor(context : Context): RecyclerView.Adapter<GameAdapter.GamesViewHolder>(){
    private val inflater : LayoutInflater = LayoutInflater.from(context)
    private var games = emptyList<Game>()


    class GamesViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val pointA : TextView = itemView.findViewById(R.id.tv_pointA)
        val pointB : TextView = itemView.findViewById(R.id.tv_pointB)
        val teamA : TextView = itemView.findViewById(R.id.tv_teamA)
        val teamB : TextView = itemView.findViewById(R.id.tv_teamB)
        val date : TextView = itemView.findViewById(R.id.tv_date)
        val win: TextView = itemView.findViewById(R.id.tv_win)


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GameAdapter.GamesViewHolder {
        val itemView = inflater.inflate(R.layout.result_game, parent, false)
        return GamesViewHolder(itemView)
    }

    override fun getItemCount(): Int = games.size

    override fun onBindViewHolder(holder: GameAdapter.GamesViewHolder, position: Int) {
        val current = games[position]
        holder.pointA.text = current.ScoreA.toString()
        holder.pointB.text = current.ScoreB.toString()
        holder.teamA.text = current.EquipoA
        holder.teamB.text = current.EquipoB
        holder.date.text = current.fecha
        holder.win.text = current.Ganador
    }

    internal fun setGames(partidos: List<Game>) {
        this.games = partidos
        notifyDataSetChanged()
    }


}