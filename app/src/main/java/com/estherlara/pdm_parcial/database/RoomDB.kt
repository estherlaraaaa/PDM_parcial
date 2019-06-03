package com.estherlara.pdm_parcial.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.estherlara.pdm_parcial.database.daos.GameDAO
import com.estherlara.pdm_parcial.database.entities.Game

@Database(entities = arrayOf(Game::class), version = 10, exportSchema = false)
public abstract class RoomBD : RoomDatabase() {

    abstract fun gameDao(): GameDAO

    companion object {
        @Volatile
        private var INSTANCE: RoomBD? = null

        fun getDatabase(context: Context): RoomBD {
            val tempInstance = INSTANCE
            if (tempInstance != null) {
                return tempInstance
            }
            synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    RoomBD::class.java,
                    "Game_database"
                ).build()
                INSTANCE = instance
                return instance
            }
        }
    }
}