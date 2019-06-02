package com.estherlara.pdm_parcial.database.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "team")
data class Team (

    @PrimaryKey
    private val id: String,

    private val name: String,
    private val points: Int
)