package com.estherlara.pdm_parcial.database.daos

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.estherlara.pdm_parcial.database.entities.Match

@Dao
interface MatchDAO {

    @Query("SELECT * FROM `match` where nameTeam =:name")
    suspend fun getOneMatch(name: String) : Match

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(match:Match)

    @Query("SELECT*FROM `match`")
    fun getAllMatch(): LiveData<List<Match>>

}