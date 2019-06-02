package com.estherlara.pdm_parcial.database.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity (tableName = "Game")
data class Game (


    @PrimaryKey(autoGenerate = true)
    var Id_Game : Int = 0,

    val TeamA : String,
    val TeamB: String,
    val pointsA: Int,
    val pointsB: Int,
    val date: String,
    val time: String,
    val win: String

)