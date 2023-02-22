package com.example.kotlinretrofit

object DataRepository {


    suspend fun getAPIResponse() : DataResult<List<Hero>> {
        val apiService = RetrofitClient.getInstance()
        return try {
            val heroes = apiService.makeAPICall()
            DataResult.success(heroes)
        } catch (e : java.lang.Exception) {
            DataResult.failure(e)
        }
    }
}