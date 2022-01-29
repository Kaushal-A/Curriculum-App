package com.adgvit.courseApp.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.adgvit.courseApp.Models.Docs
import com.adgvit.courseApp.R
import com.adgvit.courseApp.rvAdapters.CourseRVAdapter
import com.adgvit.courseApp.rvAdapters.ICourseRVAdapter
import com.adgvit.courseApp.viewModel.HomeViewModel
import com.google.android.material.appbar.CollapsingToolbarLayout

class Home : AppCompatActivity(), ICourseRVAdapter {

    lateinit var viewModel: HomeViewModel

    lateinit var collapsingToolbarLayout: CollapsingToolbarLayout
    lateinit var rcvMycourse: RecyclerView
    lateinit var rcvAllCourse: RecyclerView
    private lateinit var myCourseRvAdapter: CourseRVAdapter
    private lateinit var allCourseRVAdapter: CourseRVAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        collapsingToolbarLayout = findViewById(R.id.collapsing_toolbar)
        collapsingToolbarLayout.title = "Courses"
        viewModel = ViewModelProvider(this).get(HomeViewModel::class.java)
        rcvMycourse=findViewById(R.id.myCoursesRecycler)
        rcvAllCourse=findViewById(R.id.allCoursesRecycler)
        rcvMycourse.layoutManager = LinearLayoutManager(this)
        rcvAllCourse.layoutManager = LinearLayoutManager(this)
        myCourseRvAdapter = CourseRVAdapter(this)
        allCourseRVAdapter = CourseRVAdapter(this)
        rcvMycourse.adapter = myCourseRvAdapter
        rcvAllCourse.adapter = allCourseRVAdapter

        viewModel.allCourse.observe(this, Observer {
            allCourseRVAdapter.updateRV(it)
        })
        viewModel.myCourse.observe(this, Observer {
            myCourseRvAdapter.updateRV(it)
        })
        viewModel.errorMessage.observe(this, Observer {
            Toast.makeText(this,it,Toast.LENGTH_LONG).show()
        })
        viewModel.getAllCourse()

    }

    override fun onStarClicked(course: Docs) {
        viewModel.toggleFav(course)

    }

    override fun onItemClicked(course: Docs) {
        val intent = Intent(this, CourseActivity::class.java)
        intent.putExtra("code", course.code)
        startActivity(intent)
    }

}