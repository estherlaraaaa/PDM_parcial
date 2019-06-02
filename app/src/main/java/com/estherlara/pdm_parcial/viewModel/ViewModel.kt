package com.estherlara.pdm_parcial.viewModel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.estherlara.pdm_parcial.database.RoomDB
import com.estherlara.pdm_parcial.database.entities.Match
import com.estherlara.pdm_parcial.database.entities.Team
import com.estherlara.pdm_parcial.repository.Repository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ViewModel (application: Application) : AndroidViewModel(application){

    private val repository: Repository
    val allTeam : LiveData<List<Team>>
    val allMatch : LiveData<List<Match>>

    init {
        val TeamDao = RoomDB.getDatabase(application, viewModelScope).TeamDAO()
        val MatchDao = RoomDB.getDatabase(application, viewModelScope).MatchDAO()
        repository = Repository(TeamDao, MatchDao)

        allTeam = repository.allTeam
        allMatch = repository.allMatch
    }

    //Get one
    fun getOneTeam(name: String) = viewModelScope.launch (Dispatchers.IO){
        repository.getOneTeam(name)
    }
    fun getOneMatch(name: String) = viewModelScope.launch (Dispatchers.IO){
        repository.getOneMatch(name)
    }

    //inserts
    fun insertTeam(team: Team) = viewModelScope.launch(Dispatchers.IO) {
        repository.insert(team)
    }
    fun insertMatch(match: Match) = viewModelScope.launch(Dispatchers.IO) {
        repository.insert(match)

    }

}