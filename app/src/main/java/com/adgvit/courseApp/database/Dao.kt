package com.adgvit.courseApp.database

import androidx.lifecycle.LiveData
import androidx.room.*
import androidx.room.Dao
import com.adgvit.courseApp.dataModels.Course

@Dao
interface Dao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(course: Course)

    @Query("Delete from coursetable")
    suspend fun deleteAll()

    @Update
    suspend fun toogleFav(course: Course)

    @Query("select * from coursetable")
    fun getAllCourse() : LiveData<List<Course>>
}