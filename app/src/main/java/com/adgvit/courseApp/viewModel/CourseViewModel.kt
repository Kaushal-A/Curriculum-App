package com.adgvit.courseApp.viewModel

import android.app.Application
import android.util.Log
import android.widget.TextView
import android.widget.Toast
import androidx.lifecycle.AndroidViewModel
import retrofit2.Call
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.adgvit.courseApp.tinyDB.TinyDB
import androidx.lifecycle.ViewModel
import com.adgvit.courseApp.Models.Course
import com.adgvit.courseApp.NetworkUtils.NetworkUtils
import com.adgvit.courseApp.repo.Repo
import retrofit2.Callback
import retrofit2.Response

class CourseViewModel(application: Application): AndroidViewModel(application) {

    val course: MutableLiveData<Course> = MutableLiveData<Course>()
    val repo: Repo = Repo(NetworkUtils.getNetworkAPIInstance())
    var tinyDB : TinyDB = TinyDB(application.applicationContext)

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
        var courseData: Course
        call.enqueue(object : Callback<Course> {
            override fun onResponse(call: Call<Course>, response: Response<Course>) {
                if (!response.isSuccessful) {
                    Log.i("onResponseFailure: ", "" + response.code())
                    return
                }
                courseData = response.body()!!
                val favourites: ArrayList<String> = tinyDB.getListString("favourites")
                courseData.favourite = favourites.contains(courseData.code)
                course.postValue(courseData)
            }

            override fun onFailure(call: Call<Course>, t: Throwable) {
                Log.i("onFailure: ", "" + t.message)
            }

        })

    }

    fun onStarClicked(){
        var courseData: Course? = course.value
        if (courseData != null) {
            courseData.favourite = !courseData.favourite
            val favourites: ArrayList<String> = tinyDB.getListString("favourites")
            if (courseData.favourite) {
                favourites.add(courseData.code.toString())
                tinyDB.putListString("favourites", favourites)
                Toast.makeText(getApplication(), "Course added to My Course", Toast.LENGTH_SHORT)
                    .show()
            } else {
                favourites.remove(courseData.code.toString())
                tinyDB.putListString("favourites", favourites)
                Toast.makeText(getApplication(), "Course removed to My Course", Toast.LENGTH_SHORT)
                    .show()
            }
        }
        course.postValue(courseData!!)
    }

    fun getCourseAbbr(coursename: String): String {
        val numberOfWords:Int = wordCount(coursename)
        if(numberOfWords>1) {
            var initials = ""
            for (s in coursename.split("\\s+".toRegex())) {
                if(s.lowercase() != "and" && s.lowercase() != "or") {
                    initials += s[0].uppercase()
                }
            }
            return initials
        }
        return coursename
    }

    private fun wordCount(str: String): Int {
        val trimmedStr = str.trim()
        return if (trimmedStr.isEmpty()) {
            0
        } else {
            trimmedStr.split("\\s+".toRegex()).size
        }
    }

}