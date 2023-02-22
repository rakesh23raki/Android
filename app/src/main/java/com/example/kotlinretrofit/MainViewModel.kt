package com.example.kotlinretrofit

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainViewModel : ViewModel() {

    val dataResponse = MutableLiveData<DataResult<List<Hero>>>()

    fun makeAPICall() {
        viewModelScope.launch(Dispatchers.IO) {
        dataResponse.postValue(DataRepository.getAPIResponse())
        }
    }
}