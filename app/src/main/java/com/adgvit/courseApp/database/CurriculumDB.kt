package com.adgvit.courseApp.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.adgvit.courseApp.dataModels.Course

@Database(entities = arrayOf(Course::class), version = 1, exportSchema = false)
abstract class CurriculumDB: RoomDatabase() {
    abstract fun getDao(): Dao

    companion object {
        // Singleton prevents multiple instances of database opening at the
        // same time.
        @Volatile
        private var INSTANCE: CurriculumDB? = null

        fun getDatabase(context: Context): CurriculumDB {
            // if the INSTANCE is not null, then return it,
            // if it is, then create the database
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                        context.applicationContext,
                        CurriculumDB::class.java,
                        "CurriculumDB"
                ).build()
                INSTANCE = instance
                // return instance
                instance
            }
        }
    }
}