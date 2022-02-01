package com.adgvit.courseApp.viewModel

import android.app.Application
import android.util.Log
import android.widget.TextView
import android.widget.Toast
import androidx.lifecycle.AndroidViewModel
import retrofit2.Call
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.adgvit.courseApp.Models.Course
import com.adgvit.courseApp.NetworkUtils.NetworkUtils
import com.adgvit.courseApp.repo.Repo
import retrofit2.Callback
import retrofit2.Response

class CourseViewModel(application: Application): AndroidViewModel(application) {

    val course: MutableLiveData<Course> = MutableLiveData<Course>()
    val repo: Repo = Repo(NetworkUtils.getNetworkAPIInstance())

    fun getTextCourseDesc(textviewJ: TextView, textviewT: TextView, textviewL: TextView
    , textviewP: TextView): String {
        if(textviewJ.text.toString().toInt() > 0 && textviewT.text.toString().toInt() == 0 && textviewL.text.toString().toInt() == 0 && textviewP.text.toString().toInt() == 0)
        {
            return "Project Only"
        }
        else if(textviewL.text.toString().toInt() > 0 && textviewJ.text.toString().toInt() == 0 && textviewT.text.toString().toInt() == 0 && textviewP.text.toString().toInt() == 0)
        {
            return "Theory Only"
        }
        else if(textviewL.text.toString().toInt() == 0 && textviewJ.text.toString().toInt() == 0 && textviewT.text.toString().toInt() == 0 && textviewP.text.toString().toInt() > 0)
        {
            return "Lab Only"
        }
        else if(textviewL.text.toString().toInt() > 0 && textviewJ.text.toString().toInt() > 0 && textviewT.text.toString().toInt() == 0 && textviewP.text.toString().toInt() == 0)
        {
            return "Embedded Theory and Project"
        }
        else if(textviewL.text.toString().toInt() > 0 && textviewJ.text.toString().toInt() == 0 && textviewT.text.toString().toInt() == 0 && textviewP.text.toString().toInt() > 0)
        {
            return "Embedded Theory and Lab"
        }
        else if(textviewL.text.toString().toInt() == 0 && textviewJ.text.toString().toInt() > 0 && textviewT.text.toString().toInt() == 0 && textviewP.text.toString().toInt() > 0)
        {
            return "Embedded Lab and Project"
        }
        else if(textviewL.text.toString().toInt() > 0 && textviewJ.text.toString().toInt() > 0 && textviewT.text.toString().toInt() == 0 && textviewP.text.toString().toInt() > 0)
        {
            return "Embedded Theory, Lab and Project"
        }
        return ""
    }

    fun getCourseFromCode(code: String) {

        var call: Call<Course> = repo.getCourseFromCode(code)

        call.enqueue(object : Callback<Course> {
            override fun onResponse(call: Call<Course>, response: Response<Course>) {
                if (!response.isSuccessful) {
                    Log.i("onResponseFailure: ", "" + response.code())
                    return
                }
                course.value = response.body()
            }

            override fun onFailure(call: Call<Course>, t: Throwable) {
                Log.i("onFailure: ", "" + t.message)
            }

        })

    }

}