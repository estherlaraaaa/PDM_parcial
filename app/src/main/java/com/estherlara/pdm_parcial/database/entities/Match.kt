package com.estherlara.pdm_parcial.database.entities

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.sql.Time
import java.util.*

@Entity(tableName = "match")
data class Match (

    @PrimaryKey
    private val id: String,

    private val nameTeam: String,
    private val teamA: String,
    private val teamB: String,
    private val date: String,
    private val time: String,
    private val pointTeamA: Int,
    private val pointTeamB: Int
)