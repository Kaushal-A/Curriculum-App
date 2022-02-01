package com.adgvit.courseApp.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import android.view.WindowManager
import android.widget.EditText
import android.widget.ImageView
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.adgvit.courseApp.Models.Docs
import com.adgvit.courseApp.R
import com.adgvit.courseApp.rvAdapters.CourseRVAdapter
import com.adgvit.courseApp.rvAdapters.ICourseRVAdapter
//import com.adgvit.courseApp.rvAdapters.Settings_Adapter.intent
import com.adgvit.courseApp.viewModel.HomeViewModel
import com.google.android.material.appbar.CollapsingToolbarLayout
import kotlinx.coroutines.*
import kotlin.coroutines.CoroutineContext

class Home : AppCompatActivity(), ICourseRVAdapter, CoroutineScope {
    override val coroutineContext: CoroutineContext
        get() = Dispatchers.Main
    lateinit var viewModel: HomeViewModel

    lateinit var collapsingToolbarLayout: CollapsingToolbarLayout
    lateinit var rcvMycourse: RecyclerView
    lateinit var rcvAllCourse: RecyclerView
    private lateinit var myCourseRvAdapter: CourseRVAdapter
    private lateinit var allCourseRVAdapter: CourseRVAdapter
    private lateinit var search: EditText
    private lateinit var setting: ImageView

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
        search = findViewById(R.id.search)
        setting = findViewById(R.id.settings1)

        setting.setOnClickListener {
           val intent = Intent(this, Settings::class.java)
            startActivity(intent)
        }
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

        search.addTextChangedListener(object : TextWatcher{
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }

            override fun afterTextChanged(p0: Editable?) {

                launch {
                    delay(300)
                    withContext(Dispatchers.Main) {


                        if (p0.toString() == "" || p0 == null) {
                            search.clearFocus()
                            viewModel.getAllCourse()
                        } else {

                            viewModel.getSearchedCourse(p0.toString())
                        }

                    }
                }
            }

        })

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