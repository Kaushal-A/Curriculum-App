package com.adgvit.courseDB.NetworkUtils

import com.adgvit.courseDB.Models.Course
import com.adgvit.courseDB.Models.Docs
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