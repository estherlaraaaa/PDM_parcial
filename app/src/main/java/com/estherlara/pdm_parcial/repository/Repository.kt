package com.estherlara.pdm_parcial.repository

import androidx.annotation.WorkerThread
import androidx.lifecycle.LiveData
import com.estherlara.pdm_parcial.database.daos.MatchDAO
import com.estherlara.pdm_parcial.database.daos.TeamDAO
import com.estherlara.pdm_parcial.database.entities.Match
import com.estherlara.pdm_parcial.database.entities.Team

class Repository (private val TeamDao:TeamDAO, private val MatchDao:MatchDAO){

    val allTeam: LiveData<List<Team>> = TeamDao.getAllTeam()
    val allMatch: LiveData<List<Match>> = MatchDao.getAllMatch()

    //getOne
    @WorkerThread
    suspend fun getOneTeam(name : String){
        TeamDao.getOneTeam(name)
    }
    @WorkerThread
    suspend fun getOneMatch(name : String){
        MatchDao.getOneMatch(name)
    }

    //inserts
    @WorkerThread
    suspend fun insert(team: Team) {
        TeamDao.insert(team)
    }
    @WorkerThread
    suspend fun insert(match: Match) {
        MatchDao.insert(match)
    }

}