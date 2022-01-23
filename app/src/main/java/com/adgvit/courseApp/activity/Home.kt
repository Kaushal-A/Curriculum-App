package com.adgvit.courseApp.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.adgvit.courseApp.dataModels.Course
import com.adgvit.courseApp.databinding.ActivityHomeBinding
import com.adgvit.courseApp.rvAdapters.CourseRVAdapter
import com.adgvit.courseApp.rvAdapters.ICourseRVAdapter
import com.adgvit.courseApp.viewModel.HomeViewModel

class Home : AppCompatActivity(), ICourseRVAdapter {
    private lateinit var binding: ActivityHomeBinding
    private lateinit var myCourseRvAdapter: CourseRVAdapter
    private lateinit var allCourseRVAdapter: CourseRVAdapter
    private lateinit var myCoursesList: List<Course>
    private lateinit var allCoursesList: List<Course>
    lateinit var viewModel: HomeViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        supportActionBar?.hide()
        viewModel = ViewModelProvider(this).get(HomeViewModel::class.java)
        loadMyCourses()
        val myCoursesLayoutManager: RecyclerView.LayoutManager = LinearLayoutManager(this)
        val allCoursesLayoutManager: RecyclerView.LayoutManager = LinearLayoutManager(this)

        binding.myCoursesRecycler.layoutManager = myCoursesLayoutManager
        binding.allCoursesRecycler.layoutManager = allCoursesLayoutManager

        myCourseRvAdapter = CourseRVAdapter(myCoursesList,this)
        allCourseRVAdapter = CourseRVAdapter(allCoursesList,this)
        binding.myCoursesRecycler.adapter = myCourseRvAdapter
        binding.allCoursesRecycler.adapter = allCourseRVAdapter

    }

    private fun loadMyCourses() {
        myCoursesList = listOf(
            Course("CSE3004", "Data Structures and Algorithms",true),
            Course("CSE3004", "Data Structures and Algorithms",true),

        )
        allCoursesList = listOf(
            Course("CSE3004", "Data Structures and Algorithms",false),
            Course("CSE3004", "Data Structures and Algorithms",false),
            Course("CSE3004", "Data Structures and Algorithms",false),
            Course("CSE3004", "Data Structures and Algorithms",false),
            Course("CSE3004", "Data Structures and Algorithms",false)

        )
    }

    override fun onStarClicked(course: Course) {
        TODO("Not yet implemented")
    }

    override fun onItemClicked(course: Course) {
        TODO("Not yet implemented")
    }


}