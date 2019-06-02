package com.estherlara.pdm_parcial.database.daos

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.estherlara.pdm_parcial.database.entities.Match
import com.estherlara.pdm_parcial.database.entities.Team

@Dao
interface TeamDAO {

    @Query("SELECT * FROM team where name =:name")
    suspend fun getOneTeam(name: String) : Team

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(team: Team)

    @Query("SELECT*FROM team")
    fun getAllTeam(): LiveData<List<Team>>

}