package com.adgvit.courseApp.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.adgvit.courseApp.DataModels.Course
import com.adgvit.courseApp.databinding.ActivityHomeBinding
import com.adgvit.courseApp.rvAdapters.CourseRVAdapter

class Home : AppCompatActivity() {
    private lateinit var binding: ActivityHomeBinding
    private lateinit var myCoursesAdapter: CourseRVAdapter
    private lateinit var myCoursesList: List<Course>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        supportActionBar?.hide()

        loadMyCourses()
        val layoutManager: RecyclerView.LayoutManager = LinearLayoutManager(this)
        binding.myCoursesRecycler.layoutManager = layoutManager
        myCoursesAdapter = CourseRVAdapter(myCoursesList)
        binding.myCoursesRecycler.adapter = myCoursesAdapter
    }

    private fun loadMyCourses() {
        myCoursesList = listOf(
            Course("CSE3004", "Data Structures and Algorithms"),
            Course("CSE3004", "Data Structures and Algorithms"),
            Course("CSE3004", "Data Structures and Algorithms"),
            Course("CSE3004", "Data Structures and Algorithms"),
            Course("CSE3004", "Data Structures and Algorithms")

        )
    }
}