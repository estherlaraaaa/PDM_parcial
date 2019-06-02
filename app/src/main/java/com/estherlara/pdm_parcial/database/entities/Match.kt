package com.estherlara.pdm_parcial.database.entities

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.sql.Time
import java.util.*

@Entity(tableName = "match")
data class Match (

    @PrimaryKey
     val nameMatch: String,

     val teamA: String,
     val teamB: String,
     val date: String,
     val time: String,
     val pointTeamA: String,
     val pointTeamB: String,
     val win: String
)