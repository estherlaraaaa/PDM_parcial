package com.estherlara.pdm_parcial.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import com.estherlara.pdm_parcial.database.daos.MatchDAO
import com.estherlara.pdm_parcial.database.daos.TeamDAO
import com.estherlara.pdm_parcial.database.entities.Match
import com.estherlara.pdm_parcial.database.entities.Team
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

@Database(entities = arrayOf(Team::class, Match::class), version = 4, exportSchema = false)
public abstract class RoomDB : RoomDatabase() {

    abstract fun TeamDAO() : TeamDAO
    abstract fun MatchDAO() : MatchDAO

    companion object{
        @Volatile
        private var INSTANCE: RoomDB?= null

        fun getDatabase(context: Context, scope: CoroutineScope): RoomDB {
            val tempInstance = INSTANCE
            if (tempInstance != null) {
                return tempInstance
            }
            synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    RoomDB::class.java,
                    "Basketball_database"
                ).fallbackToDestructiveMigration().
                    addCallback(BasketballDatabaseCallback(scope))
                    .build()
                INSTANCE = instance
                return instance
            }
        }
        private class BasketballDatabaseCallback(
            private val scope: CoroutineScope
        ) : RoomDatabase.Callback() {
            override fun onOpen(db: SupportSQLiteDatabase) {
                super.onOpen(db)
                INSTANCE?.let { database ->
                    scope.launch {
                        populateDatabase(database.TeamDAO(), database.MatchDAO())
                    }
                }
            }
        }
        suspend fun populateDatabase(TeamDAO:TeamDAO, MatchDAO:MatchDAO){

            //Inserts team
            TeamDAO.insert(Team( "Warriors", "119", "01/05/2019", "13:50"))
            TeamDAO.insert(Team( "Raptors", "108", "25/03/19", "18:30"))

            //inserts match
            MatchDAO.insert(Match("Final", "Warriors", "Raptors", "01/05/2019", "01:30", "109", "108", "Raptors"))
            MatchDAO.insert(Match("Semi final", "Warriors", "Raptors", "07/07/2019", "04:30", "25", "100", "Raptors"))
        }
    }
}