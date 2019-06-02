package com.estherlara.pdm_parcial.database.entities

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.sql.Time
import java.util.*

@Entity(tableName = "match")
data class Match (

    @PrimaryKey
     val nameMatch: String = "ja",

     val teamA: String = "ja",
     val teamB: String = "ja",
     val date: String = "ja",
     val time: String = "ja",
     val pointTeamA: String = "ja",
     val pointTeamB: String = "ja",
     val win: String = "ja"
)