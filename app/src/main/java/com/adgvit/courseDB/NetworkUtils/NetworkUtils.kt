package com.adgvit.courseDB.NetworkUtils

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class NetworkUtils {


    companion object{
        val BASE_URL: String = "http://curriculum-app-adg.herokuapp.com/"
        fun getRetrofitInstance(): Retrofit =
            Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()

        fun getNetworkAPIInstance(): NetworkAPI =
            getRetrofitInstance().create(NetworkAPI::class.java)
    }



}