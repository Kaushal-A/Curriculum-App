package com.adgvit.courseApp.repo

import androidx.lifecycle.LiveData
import com.adgvit.courseApp.Models.Docs
import com.adgvit.courseApp.NetworkUtils.NetworkAPI
import com.adgvit.courseApp.NetworkUtils.NetworkUtils
import retrofit2.Call
import java.util.ArrayList

class Repo {
    lateinit var allCourses: LiveData<List<Docs>>

    suspend fun getAllCourse(): LiveData<List<Docs>>{
        val call: Call<List<Docs>> = NetworkUtils().getNetworkAPIInstance().getAllCurriculums()
        allCourses=ArrayList<>()
    }
}