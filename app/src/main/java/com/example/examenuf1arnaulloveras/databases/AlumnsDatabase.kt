package com.example.examenuf1arnaulloveras.databases

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.examenuf1arnaulloveras.model.Alumns

@Database(
    entities = [Alumns::class],
    version = 1,
    exportSchema = false
)

abstract class AlumnsDatabase : RoomDatabase() {
    abstract fun alumnsDao() : AlumnsDao

    companion object {

        @Volatile
        private var INSTANCE: AlumnsDatabase? = null

        fun getDatabase(context: Context): AlumnsDatabase {
            // if the INSTANCE is not null, then return it,
            // if it is, then create the database
            if (INSTANCE == null) {
                synchronized(this) {
                    // Pass the database to the INSTANCE
                    INSTANCE = buildDatabase(context)
                }
            }
            // Return database.
            return INSTANCE!!
        }

        private fun buildDatabase(context: Context): AlumnsDatabase {
            return Room.databaseBuilder(
                context.applicationContext,
                AlumnsDatabase::class.java,
                "alumns_database"
            )
                .build()
        }
    }
}