package com.adgvit.courseApp.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.adgvit.courseApp.Models.Docs
import com.adgvit.courseApp.NetworkUtils.NetworkUtils
import com.adgvit.courseApp.R
import com.adgvit.courseApp.repo.Repo
import com.adgvit.courseApp.rvAdapters.CourseRVAdapter
import com.adgvit.courseApp.rvAdapters.ICourseRVAdapter
import com.adgvit.courseApp.viewModel.HomeViewModel
import com.adgvit.courseApp.viewModel.HomeViewModelFactory
import com.google.android.material.appbar.CollapsingToolbarLayout

class Home : AppCompatActivity(), ICourseRVAdapter {

    lateinit var homeViewModel: HomeViewModel

    lateinit var collapsingToolbarLayout: CollapsingToolbarLayout
    lateinit var rcvMycourse: RecyclerView
    lateinit var rcvAllCourse: RecyclerView
    private lateinit var myCourseRvAdapter: CourseRVAdapter
    private lateinit var allCourseRVAdapter: CourseRVAdapter
    private val repo: Repo = Repo(NetworkUtils.getNetworkAPIInstance())

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        collapsingToolbarLayout = findViewById(R.id.collapsing_toolbar)
        collapsingToolbarLayout.title = "Courses"
//        viewModel = ViewModelProvider(this).get(HomeViewModel::class.java)
        rcvMycourse=findViewById(R.id.myCoursesRecycler)
        rcvAllCourse=findViewById(R.id.allCoursesRecycler)
        rcvMycourse.layoutManager = LinearLayoutManager(this)
        rcvAllCourse.layoutManager = LinearLayoutManager(this)
        myCourseRvAdapter = CourseRVAdapter(this)
        allCourseRVAdapter = CourseRVAdapter(this)
        rcvMycourse.adapter = myCourseRvAdapter
        rcvAllCourse.adapter = allCourseRVAdapter

        homeViewModel = ViewModelProvider(this, HomeViewModelFactory(repo, application))[HomeViewModel::class.java]


        homeViewModel.allCourse.observe(this, Observer {
            allCourseRVAdapter.updateRV(it)
        })
        homeViewModel.errorMessage.observe(this, Observer {
            Toast.makeText(this,it,Toast.LENGTH_LONG)
        })
        homeViewModel.getAllCourse()
    }

    override fun onStarClicked(course: Docs) {
        TODO("Not yet implemented")
    }

    override fun onItemClicked(course: Docs) {
        TODO("Not yet implemented")
    }

}