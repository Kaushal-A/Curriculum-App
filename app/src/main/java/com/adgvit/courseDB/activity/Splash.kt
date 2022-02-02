package com.adgvit.courseDB.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.adgvit.courseDB.R
import kotlinx.coroutines.*
import kotlin.coroutines.CoroutineContext

class Splash : AppCompatActivity(),CoroutineScope {
    override val coroutineContext: CoroutineContext
    get() = Dispatchers.Main
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)


        launch {
            delay(2000)
            withContext(Dispatchers.Main){
                launchHome()
            }
        }


    }
    private fun launchHome(){
        startActivity(Intent(this,Home::class.java))
        finish()
    }
}