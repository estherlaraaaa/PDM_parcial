package com.estherlara.pdm_parcial.database.entities

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.sql.Time
import java.util.*

@Entity
data class Partido (

    @PrimaryKey
    private val id: Int,

    private val teamA: String,
    private val teamB: String,
    private val date: Date,
    private val time: Time,
    private val points: Int
)