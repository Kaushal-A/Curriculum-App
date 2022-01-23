package com.adgvit.courseApp.activity

import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.Observer
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
        val myCoursesLayoutManager: RecyclerView.LayoutManager = LinearLayoutManager(this)
        val allCoursesLayoutManager: RecyclerView.LayoutManager = LinearLayoutManager(this)
        viewModel = ViewModelProvider(this).get(HomeViewModel::class.java)
        loadMyCourses()
        binding.myCoursesRecycler.layoutManager = myCoursesLayoutManager
        binding.allCoursesRecycler.layoutManager = allCoursesLayoutManager
        myCourseRvAdapter = CourseRVAdapter(this)
        allCourseRVAdapter = CourseRVAdapter(this)
        binding.myCoursesRecycler.adapter = myCourseRvAdapter
        binding.allCoursesRecycler.adapter = allCourseRVAdapter
        val sp: SharedPreferences = getSharedPreferences("com.adgvit.course", MODE_PRIVATE)
        if(sp.getBoolean("first",true)){
        viewModel.insertAll(allCoursesList)
        viewModel.insertAll(myCoursesList)

        }

        viewModel.allCourse.observe(this, Observer {list ->
            list?.let {
                allCourseRVAdapter.updateRV(it)

            }

        })
        viewModel.myCourse.observe(this, Observer { list->
            list?.let {
                myCourseRvAdapter.updateRV(it)
            }
        })




    }

    private fun loadMyCourses() {
        myCoursesList = listOf(
            Course("CSE3001", "Data Structures and Algorithms",true),
            Course("CSE3007", "Data Structures and Algorithms",true),

        )
        allCoursesList = listOf(
            Course("CSE3002", "Data Structures and Algorithms",false),
            Course("CSE3003", "Data Structures and Algorithms",false),
            Course("CSE3004", "Data Structures and Algorithms",false),
            Course("CSE3005", "Data Structures and Algorithms",false),
            Course("CSE3006", "Data Structures and Algorithms",false)

        )
    }

    override fun onStarClicked(course: Course) {
        viewModel.toggleFav(course)
        Toast.makeText(applicationContext,"Added to My Course", Toast.LENGTH_LONG).show()
    }

    override fun onItemClicked(course: Course) {

    }


}