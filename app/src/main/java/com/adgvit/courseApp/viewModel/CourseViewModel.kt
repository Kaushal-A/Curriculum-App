package com.adgvit.courseApp.viewModel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.adgvit.courseApp.repo.Repo

class CourseViewModel(application: Application): AndroidViewModel(application) {

    val repo: Repo

    init {
        repo = Repo(application)
    }



}