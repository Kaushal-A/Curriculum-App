package com.adgvit.courseApp.viewModel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.adgvit.courseApp.Models.Docs
import com.adgvit.courseApp.NetworkUtils.NetworkUtils
import com.adgvit.courseApp.repo.Repo
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class HomeViewModel(application: Application) : AndroidViewModel(application) {


    val repo: Repo = Repo(NetworkUtils.getNetworkAPIInstance())
    val allCourse = MutableLiveData<List<Docs>>()
    val myCourse = MutableLiveData<List<Docs>>()
    val errorMessage = MutableLiveData<String>()
//    val allCourse: LiveData<List<Course>>
//    val myCourse: LiveData<List<Course>>
    fun getAllCourse(){

        val call = repo.getAllCourse()
        call.enqueue(object: Callback<List<Docs>>{
            override fun onResponse(call: Call<List<Docs>>, response: Response<List<Docs>>) {
                if(!response.isSuccessful){
                    errorMessage.postValue(response.message())
                    return
                }
                else{
                    for(doc in response.body()!!){

                    }
                }

            }

            override fun onFailure(call: Call<List<Docs>>, t: Throwable) {
                errorMessage.postValue(t.message)
            }

        })
    }


}