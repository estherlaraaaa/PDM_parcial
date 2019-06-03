package com.estherlara.pdm_parcial.database.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity (tableName = "Game")
data class Game (

    @ColumnInfo(name="TeamA")
    val EquipoA : String,

    @ColumnInfo(name="TeamB")
    val EquipoB: String,

    @ColumnInfo(name="ScoreA")
    val ScoreA: Int,

    @ColumnInfo(name="ScoreB")
    val ScoreB : Int,

    @ColumnInfo(name = "Fecha")
    val fecha : String,

    @ColumnInfo(name="Ganador")
    val Ganador : String
){

    @PrimaryKey(autoGenerate = true)
    var Id_Game : Int = 0

}