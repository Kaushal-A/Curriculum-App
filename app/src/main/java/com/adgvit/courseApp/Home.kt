package com.adgvit.courseApp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.adgvit.courseApp.databinding.ActivityHomeBinding

class Home : AppCompatActivity() {
    private lateinit var binding: ActivityHomeBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(R.layout.activity_home)

    }
}