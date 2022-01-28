package com.adgvit.courseApp.repo

import android.widget.Toast
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.adgvit.courseApp.Models.Docs
import com.adgvit.courseApp.NetworkUtils.NetworkAPI
import com.adgvit.courseApp.NetworkUtils.NetworkUtils
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.util.ArrayList

class Repo(val networkAPI: NetworkAPI) {
    fun getAllCourse(): Call<List<Docs>> = networkAPI.getAllCurriculums()
}