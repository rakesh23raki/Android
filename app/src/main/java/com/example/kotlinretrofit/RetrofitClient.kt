package com.example.kotlinretrofit

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitClient {

    lateinit var apiService : APIService

    fun getInstance() : APIService {
        if(::apiService.isInitialized) {
            return apiService
        }
        val retrofit = Retrofit.Builder().addConverterFactory(GsonConverterFactory.create()).client(OkHttpClient()).baseUrl("https://simplifiedcoding.net/").build()
        apiService = retrofit.create(APIService::class.java)
        return  apiService
    }

}