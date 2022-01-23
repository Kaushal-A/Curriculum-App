package com.adgvit.courseApp.viewModel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.adgvit.courseApp.Repo.HomeRepo
import com.adgvit.courseApp.dataModels.Course
import com.adgvit.courseApp.database.CurriculumDB
import com.adgvit.courseApp.database.Dao
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class HomeViewModel(application: Application) : AndroidViewModel(application) {
    val repo: HomeRepo
    val allCourse: LiveData<List<Course>>
    init {
        val dao = CurriculumDB.getDatabase(application).getDao()
        repo = HomeRepo(dao)
        allCourse=repo.allCourse

    }
    fun insert(course: Course) = viewModelScope.launch(Dispatchers.IO){
        repo.insert(course)
    }
    fun toggleFav(course: Course) = viewModelScope.launch(Dispatchers.IO){
        repo.toogleFav(course)
    }
    fun deleteAll() = viewModelScope.launch(Dispatchers.IO){
        repo.deleteAll()
    }

}