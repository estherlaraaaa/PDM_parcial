package com.estherlara.pdm_parcial.database.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "team")
data class Team (

    @PrimaryKey val name: String = "ja",

     val points: String = "ja",
     val date: String = "ja",
     val time: String = "ja"
)