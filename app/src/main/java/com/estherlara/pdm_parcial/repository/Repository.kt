package com.estherlara.pdm_parcial.repository

import androidx.annotation.WorkerThread
import androidx.lifecycle.LiveData
import com.estherlara.pdm_parcial.database.daos.GameDAO
import com.estherlara.pdm_parcial.database.entities.Game

class Repository (private val gameDAO: GameDAO){

    val allGames : LiveData<List<Game>> = gameDAO.getAllGames()

    @WorkerThread
    suspend fun insert(game : Game){
        gameDAO.insert(game)
    }

}