package com.estherlara.pdm_parcial.database.daos

import androidx.room.Dao
import androidx.lifecycle.LiveData
import androidx.room.Insert
import androidx.room.Query
import com.estherlara.pdm_parcial.database.entities.Game

@Dao
interface GameDAO {

        @Query("Select * from Game order by Id_Game desc")
        fun getAllGames() : LiveData<List<Game>>

        @Insert
        suspend fun insert(game: Game)
}