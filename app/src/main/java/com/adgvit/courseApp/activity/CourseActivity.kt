package com.adgvit.courseApp.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.adgvit.courseApp.R
import com.adgvit.courseApp.databinding.ActivityCourseBinding
import com.adgvit.courseApp.databinding.ActivityHomeBinding
import com.google.android.material.tabs.TabLayout

class CourseActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityCourseBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)



    }
}