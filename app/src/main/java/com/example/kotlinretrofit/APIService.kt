package com.example.kotlinretrofit

import retrofit2.http.GET

interface APIService {


    @GET("demos/marvel/")
    suspend fun makeAPICall() : List<Hero>
}