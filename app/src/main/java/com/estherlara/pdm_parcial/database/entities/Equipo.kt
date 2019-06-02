package com.estherlara.pdm_parcial.database.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Equipo (

    @PrimaryKey
    private val id: Int,

    private val name: String,
    private val points: Int
)