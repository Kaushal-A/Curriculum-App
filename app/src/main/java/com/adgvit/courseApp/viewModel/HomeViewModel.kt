package com.adgvit.courseApp.viewModel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.adgvit.courseApp.Models.Course
import com.adgvit.courseApp.repo.Repo

class HomeViewModel(application: Application) : AndroidViewModel(application) {

//    val repo: HomeRepo
//    val allCourse: LiveData<List<Course>>
//    val myCourse: LiveData<List<Course>>

    val repo: Repo

    init {
        repo = Repo(application)
//        val dao = CurriculumDB.getDatabase(application).getDao()
//        repo = HomeRepo(dao)
//        allCourse=repo.allCourse
//        myCourse=repo.myCourse
    }

    fun getCourse(code: String): Course =
        repo.getCourse(code)

//    fun insert(course: Course) = viewModelScope.launch(Dispatchers.IO){
//        repo.insert(course)
//    }
//    fun toggleFav(course: Course) = viewModelScope.launch(Dispatchers.IO){
//        repo.toogleFav(course)
//    }
//    fun deleteAll() = viewModelScope.launch(Dispatchers.IO){
//        repo.deleteAll()
//    }
//    fun insertAll(allCourses: List<Course>) = viewModelScope.launch(Dispatchers.IO) {
//        repo.insertAll(allCourses)
//    }

}