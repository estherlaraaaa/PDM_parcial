package com.estherlara.pdm_parcial.database.entities

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.sql.Time
import java.util.*

@Entity(tableName = "match")
data class Match (

    @PrimaryKey
    private val id: String,

    private val teamA: String,
    private val teamB: String,
    private val date: Date,
    private val time: Time,
    private val points: Int
)