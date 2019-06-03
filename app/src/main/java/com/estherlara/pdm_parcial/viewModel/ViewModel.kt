package com.estherlara.pdm_parcial.viewModel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.estherlara.pdm_parcial.database.RoomBD
import com.estherlara.pdm_parcial.database.entities.Game
import com.estherlara.pdm_parcial.repository.Repository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ViewModel (application: Application) : AndroidViewModel(application){

    private val repository: Repository
    val allGames : LiveData<List<Game>>
    init {
        val gameDao = RoomBD.getDatabase(application).gameDao()
        repository = Repository(gameDao)
        allGames = repository.allGames

    }

    fun insert(game : Game) = viewModelScope.launch (Dispatchers.IO){
        repository.insert(game)
    }

}