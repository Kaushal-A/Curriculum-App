package com.adgvit.courseApp.NetworkUtils

import android.telecom.Call
import com.adgvit.courseApp.Models.AllCourses
import com.adgvit.courseApp.Models.Course
import com.adgvit.courseApp.Models.Docs
import org.json.JSONObject
import retrofit2.http.*

interface NetworkAPI {

//    @Headers("Authorization: E5sRRXq3mS2BoUJ")
//    @GET("curriculum")
//    fun getAllCurriculums(@Query("page") pageNo: String): retrofit2.Call<AllCourses>

    @Headers("Authorization: E5sRRXq3mS2BoUJ")
    @GET("curriculum")
    fun getAllCurriculums(): retrofit2.Call<List<Docs>>

    @Headers("Authorization: E5sRRXq3mS2BoUJ")
    @GET("curriculum/code/{code}")
    fun getCourseFromCode(@Path("code") code: String): retrofit2.Call<Course>


    @Headers("Authorization: E5sRRXq3mS2BoUJ")
    @GET("curriculum/search")
    fun getSearchedCurriculums(@Query("q") searchText: String): retrofit2.Call<List<Docs>>


}