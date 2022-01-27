package com.adgvit.courseApp.NetworkUtils

import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.io.IOException

class NetworkUtils {

    val BASE_URL: String = "http://curriculum-app-adg.herokuapp.com/"

    fun getRetrofitInstance(): Retrofit =
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

    fun getNetworkAPIInstance(): NetworkAPI =
        getRetrofitInstance().create(NetworkAPI::class.java)

}