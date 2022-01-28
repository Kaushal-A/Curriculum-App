package com.adgvit.courseApp.activity

import android.content.Intent
import android.content.SharedPreferences
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.adgvit.courseApp.Models.AllCourses
import com.adgvit.courseApp.NetworkUtils.NetworkUtils
import com.adgvit.courseApp.R
import com.adgvit.courseApp.databinding.ActivityHomeBinding
import com.adgvit.courseApp.viewModel.HomeViewModel
import com.google.android.material.appbar.CollapsingToolbarLayout
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import org.json.JSONObject
class Home : AppCompatActivity() {

    lateinit var viewModel: HomeViewModel

    lateinit var collapsingToolbarLayout: CollapsingToolbarLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        collapsingToolbarLayout = findViewById(R.id.collapsing_toolbar)
        collapsingToolbarLayout.title = "Courses"



        viewModel = ViewModelProvider(this).get(HomeViewModel::class.java)

    }

}