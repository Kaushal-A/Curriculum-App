package com.adgvit.courseApp.viewModel

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.adgvit.courseApp.repo.Repo

class HomeViewModelFactory constructor(private  val repository: Repo, val application: Application): ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return if (modelClass.isAssignableFrom(HomeViewModel::class.java)) {
            HomeViewModel(this.repository, this.application) as T
        } else {
            throw IllegalArgumentException("ViewModel Not Found")
        }
    }

}