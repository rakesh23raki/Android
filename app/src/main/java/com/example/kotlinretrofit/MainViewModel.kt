package com.example.kotlinretrofit

import android.app.Application
import android.content.Context
import android.content.pm.ApplicationInfo
import android.content.pm.PackageManager
import android.os.Build
import android.widget.Toast
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainViewModel : ViewModel() {

    //val SECRET_KEY = "2237-7564"

    val dataResponse = MutableLiveData<DataResult<List<Hero>>>()

    fun makeAPICall(context : Context) {
        val k : String = BuildConfig.KEY
        //context.applicationContext.applicationInfo.metaData["KEY"]
        //Toast.makeText(context,
        //context.applicationContext.packageManager.getPackageInfo(context.packageName,PackageManager.GET_SIGNING_CERTIFICATES).signingInfo?.apkContentsSigners?.get(0)?.toCharsString()?:"",Toast.LENGTH_LONG).show()
//        val KEY = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
//            context.applicationContext.packageManager.getApplicationInfo(context.packageName,
//                PackageManager.ApplicationInfoFlags.of(PackageManager.GET_META_DATA.toLong())).metaData?.getString("KEY")?:""
//        } else {
//            context.applicationContext.packageManager.getApplicationInfo(context.packageName,
//                0).metaData?.getString("KEY")?:""
//        }
        viewModelScope.launch(Dispatchers.IO) {
            dataResponse.postValue(DataRepository.getAPIResponse())
        }
    }
}