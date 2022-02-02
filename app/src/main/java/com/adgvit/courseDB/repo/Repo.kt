package com.adgvit.courseDB.repo

import com.adgvit.courseDB.Models.Course
import com.adgvit.courseDB.Models.Docs
import com.adgvit.courseDB.NetworkUtils.NetworkAPI
import retrofit2.Call

class Repo(val networkAPI: NetworkAPI) {

    fun getAllCourse(): Call<List<Docs>> = networkAPI.getAllCurriculums()

    fun getCourseFromCode(code: String): Call<Course> = networkAPI.getCourseFromCode(code)

    fun getSearchedCourse(str: String): Call<List<Docs>> = networkAPI.getSearchedCurriculums(str)

}