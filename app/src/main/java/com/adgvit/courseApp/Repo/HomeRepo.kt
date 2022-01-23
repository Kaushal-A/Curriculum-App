package com.adgvit.courseApp.Repo

import androidx.lifecycle.LiveData
import com.adgvit.courseApp.dataModels.Course
import com.adgvit.courseApp.database.Dao

class HomeRepo(private val dao: Dao) {
    val allCourse: LiveData<List<Course>> = dao.getAllCourse()

    suspend fun insert(course: Course){
        dao.insert(course)
    }

    suspend fun deleteAll(){
        dao.deleteAll()
    }
    suspend fun toogleFav(course: Course){
        dao.toogleFav(course)
    }
}