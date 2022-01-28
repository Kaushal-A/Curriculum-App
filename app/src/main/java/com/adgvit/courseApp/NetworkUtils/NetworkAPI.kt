package com.adgvit.courseApp.NetworkUtils

import android.telecom.Call
import com.adgvit.courseApp.Models.AllCourses
import com.adgvit.courseApp.Models.Docs
import org.json.JSONObject
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Headers
import retrofit2.http.Query

interface NetworkAPI {

//    @Headers("Authorization: E5sRRXq3mS2BoUJ")
//    @GET("curriculum")
//    fun getAllCurriculums(@Query("page") pageNo: String): retrofit2.Call<AllCourses>

    @Headers("Authorization: E5sRRXq3mS2BoUJ")
    @GET("curriculum")
    fun getAllCurriculums(): retrofit2.Call<List<Docs>>
}