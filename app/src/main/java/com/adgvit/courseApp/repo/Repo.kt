package com.adgvit.courseApp.repo

import android.app.Application
import android.widget.Toast
import androidx.lifecycle.LiveData
import com.adgvit.courseApp.Models.Course
import com.adgvit.courseApp.Models.Docs
import com.adgvit.courseApp.NetworkUtils.NetworkAPI
import com.adgvit.courseApp.NetworkUtils.NetworkUtils
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.util.ArrayList

class Repo(private val application: Application) {

    fun getCourse(code: String): Course {
        var course: Course = Course()
        var call: Call<Course> = NetworkUtils().getNetworkAPIInstance().getCourseFromCode(code)
        call.enqueue(object : Callback<Course> {
            override fun onResponse(call: Call<Course>, response: Response<Course>) {
                if (!response.isSuccessful) {
                    Toast.makeText(application.applicationContext, "" + response.code(), Toast.LENGTH_LONG).show()
                    return
                }
                course = response.body()!!
            }

            override fun onFailure(call: Call<Course>, t: Throwable) {
                Toast.makeText(application.applicationContext, "" + t.message, Toast.LENGTH_LONG).show()
            }

        })
        return course
    }

}