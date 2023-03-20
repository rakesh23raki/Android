package com.example.kotlinretrofit

import android.content.pm.PackageManager
import android.os.Bundle
import android.util.Base64
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.ui.AppBarConfiguration
import com.example.kotlinretrofit.databinding.ActivityMainBinding
import okhttp3.internal.Util

class MainActivity : AppCompatActivity() {

    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var binding: ActivityMainBinding
    private lateinit var viewModel: MainViewModel

    init {
        System.loadLibrary("custom_library")
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        viewModel = ViewModelProviders.of(this).get(MainViewModel::class.java)
        setContentView(binding.root)
        setSupportActionBar(binding.toolbar)

        viewModel.dataResponse.observe(this, Observer {response->
            when(response) {
                is DataResult.success -> {
                    //Toast.makeText(this, " API success",Toast.LENGTH_SHORT).show()
                }
                is DataResult.failure -> {
                    //Toast.makeText(this, " API failure",Toast.LENGTH_SHORT).show()
                }
            }
        })
        binding.fetch.setOnClickListener { view ->


            viewModel.makeAPICall(applicationContext)
            val key =
                applicationContext.packageManager.getPackageInfo(packageName,
                    PackageManager.GET_SIGNING_CERTIFICATES).signingInfo?.apkContentsSigners?.get(0)?.toCharsString()?:""
            binding.key.setText("package Name: $packageName \n $key")

//            com.rakesh.authentication.Util.methodCall()
            Toast.makeText(this, "Density = ${resources.displayMetrics.density}  W = " + binding.image.layoutParams.width + " WM = " + binding.image.width , Toast.LENGTH_LONG).show()
        }

        val siteKey = String(Base64.decode(stringFromJNI(), Base64.DEFAULT))
        Log.d("SITE_KEY",siteKey)
        //Toast.makeText(this,siteKey,Toast.LENGTH_SHORT).show()

    }

    external fun stringFromJNI(): String



}