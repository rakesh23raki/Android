package com.example.kotlinretrofit

sealed interface DataResult<T> {
    open class success<T>(data : T) : DataResult<T>
    open class failure<T>(exception: java.lang.Exception) : DataResult<T>
}