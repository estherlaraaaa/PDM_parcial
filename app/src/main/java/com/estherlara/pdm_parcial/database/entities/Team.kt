package com.estherlara.pdm_parcial.database.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "team")
data class Team (

    @PrimaryKey val name: String,

     val points: String,
     val date: String,
     val time: String
)