package com.adgvit.courseApp.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.adgvit.courseApp.Models.Course
import com.adgvit.courseApp.NetworkUtils.NetworkUtils
import com.adgvit.courseApp.R
import com.adgvit.courseApp.databinding.ActivityCourseBinding
import com.adgvit.courseApp.databinding.ActivityHomeBinding
import com.google.android.material.tabs.TabLayout
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class CourseActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_course)

        var call: Call<Course> = NetworkUtils().getNetworkAPIInstance().getCurriculumFromCode("CSE2013")

        GlobalScope.launch {
            Log.i("MADARCHOD", call.execute().body()?.code.toString())
        }

    }
}