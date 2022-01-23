package com.adgvit.courseApp.database

import androidx.lifecycle.LiveData
import androidx.room.*
import androidx.room.Dao
import com.adgvit.courseApp.dataModels.Course

@Dao
interface Dao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(course: Course)

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertAll(allCourse:List<Course>)

    @Query("Delete from coursetable")
    suspend fun deleteAll()

    @Update
    suspend fun toogleFav(course: Course)

    @Query("select * from coursetable where favourite=0 order by courseCode ASC")
    fun getAllCourse() : LiveData<List<Course>>
    @Query("select * from coursetable where favourite=1")
    fun getMyCourse() : LiveData<List<Course>>
}