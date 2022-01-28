package com.adgvit.courseApp.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import com.adgvit.courseApp.Models.Course
import com.adgvit.courseApp.NetworkUtils.NetworkUtils
import com.adgvit.courseApp.R
import com.adgvit.courseApp.databinding.ActivityCourseBinding
import com.adgvit.courseApp.databinding.ActivityHomeBinding
import com.adgvit.courseApp.viewModel.HomeViewModel
import com.google.android.material.tabs.TabLayout
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class CourseActivity : AppCompatActivity() {

    private lateinit var viewModel: HomeViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_course)

        viewModel = ViewModelProvider(this).get(HomeViewModel::class.java)

        Toast.makeText(applicationContext, "" + viewModel.getCourse("CSE2013").code, Toast.LENGTH_LONG).show()

    }
}