package com.adgvit.courseApp.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.adgvit.courseApp.R
import com.adgvit.courseApp.databinding.ActivityCourseBinding
import com.adgvit.courseApp.databinding.ActivityHomeBinding
import com.adgvit.courseApp.viewModel.CourseViewModel
import com.google.android.material.tabs.TabLayout

class CourseActivity : AppCompatActivity() {

    lateinit var courseViewModel: CourseViewModel

    lateinit var textviewL: TextView
    lateinit var textviewT: TextView
    lateinit var textviewP: TextView
    lateinit var textviewJ: TextView
    lateinit var textviewCredits: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityCourseBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        textviewJ = findViewById(R.id.J_text_view)
        textviewT = findViewById(R.id.T_text_view)
        textviewL = findViewById(R.id.L_text_view)
        textviewP = findViewById(R.id.P_text_view)
        textviewCredits = findViewById(R.id.credits_text_view)

        courseViewModel = ViewModelProvider(this, ViewModelProvider.AndroidViewModelFactory(application)).get(CourseViewModel::class.java)

        courseViewModel.course.observe(this, Observer {
            Toast.makeText(applicationContext, "" + it.code, Toast.LENGTH_LONG).show()
            Log.i("MADARCHODNIYO", "" + it.code)
            textviewJ.text = it.credits?.J
            textviewT.text = it.credits?.T
            textviewL.text = it.credits?.L
            textviewP.text = it.credits?.P
            textviewCredits.text = it.credits?.C
        })

        // Toast.makeText(applicationContext, "BHAIIIIAIS", Toast.LENGTH_LONG).show()
        courseViewModel.getCourseFromCode("CSE2013")



    }
}