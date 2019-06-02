package com.estherlara.pdm_parcial.database.entities

import java.sql.Time
import java.util.*


data class Partido (
    private val teamA: String,
    private val teamB: String,
    private val date: Date,
    private val time: Time
)