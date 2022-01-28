package com.adgvit.courseApp.viewModel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.adgvit.courseApp.Models.Docs
import com.adgvit.courseApp.NetworkUtils.NetworkUtils
import com.adgvit.courseApp.repo.Repo
import com.adgvit.courseApp.tinyDB.TinyDB
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class HomeViewModel(application: Application) : AndroidViewModel(application) {


    val repo: Repo = Repo(NetworkUtils.getNetworkAPIInstance())
    val allCourse = MutableLiveData<List<Docs>>()
    val myCourse = MutableLiveData<List<Docs>>()
    val errorMessage = MutableLiveData<String>()
    var tinyDB : TinyDB = TinyDB(application.applicationContext)

    //    val allCourse: LiveData<List<Course>>
//    val myCourse: LiveData<List<Course>>
    fun getAllCourse(){

        val call: Call<List<Docs>> = repo.getAllCourse()
        call.enqueue(object: Callback<List<Docs>>{
            override fun onResponse(call: Call<List<Docs>>, response: Response<List<Docs>>) {
                val allCourseList= ArrayList<Docs>()
                val myCourseList= ArrayList<Docs>()

                var favourites: ArrayList<String>

                if(!response.isSuccessful){
                    errorMessage.postValue(response.message())
                    return
                }
                else{
                    favourites  = tinyDB.getListString("favourites")

                    for(doc in response.body()!!){
                        if(!favourites.contains(doc.code))
                          allCourseList.add(doc)
                        else{
                            doc.favourite = true
                            myCourseList.add(doc)
                        }
                    }
                    allCourse.postValue(allCourseList)
                    myCourse.postValue(myCourseList)
                }

            }

            override fun onFailure(call: Call<List<Docs>>, t: Throwable) {
                errorMessage.postValue(t.message)
            }

        })
    }


}