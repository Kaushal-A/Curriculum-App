package com.adgvit.courseApp.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.adgvit.courseApp.dataModels.Course
import com.adgvit.courseApp.databinding.ActivityHomeBinding
import com.adgvit.courseApp.rvAdapters.CourseRVAdapter

class Home : AppCompatActivity() {
    private lateinit var binding: ActivityHomeBinding
    private lateinit var myCourseRvAdapter: CourseRVAdapter
    private lateinit var allCourseRVAdapter: CourseRVAdapter
    private lateinit var myCoursesList: List<Course>
    private lateinit var allCoursesList: List<Course>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        supportActionBar?.hide()

        loadMyCourses()
        val myCoursesLayoutManager: RecyclerView.LayoutManager = LinearLayoutManager(this)
        val allCoursesLayoutManager: RecyclerView.LayoutManager = LinearLayoutManager(this)

        binding.myCoursesRecycler.layoutManager = myCoursesLayoutManager
        binding.allCoursesRecycler.layoutManager = allCoursesLayoutManager

        myCourseRvAdapter = CourseRVAdapter(myCoursesList)
        allCourseRVAdapter = CourseRVAdapter(allCoursesList)
        binding.myCoursesRecycler.adapter = myCourseRvAdapter
        binding.allCoursesRecycler.adapter = allCourseRVAdapter

    }

    private fun loadMyCourses() {
        myCoursesList = listOf(
            Course("CSE3004", "Data Structures and Algorithms",true),
            Course("CSE3004", "Data Structures and Algorithms",true),

        )
        allCoursesList = listOf(
            Course("CSE3004", "Data Structures and Algorithms"),
            Course("CSE3004", "Data Structures and Algorithms"),
            Course("CSE3004", "Data Structures and Algorithms"),
            Course("CSE3004", "Data Structures and Algorithms"),
            Course("CSE3004", "Data Structures and Algorithms")

        )
    }
}