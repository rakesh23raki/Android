package com.example.kotlinretrofit

import android.os.Bundle
import android.util.Log
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import com.example.kotlinretrofit.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var binding: ActivityMainBinding
    private lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        viewModel = ViewModelProviders.of(this).get(MainViewModel::class.java)
        setContentView(binding.root)
        setSupportActionBar(binding.toolbar)

        viewModel.dataResponse.observe(this, Observer {response->
            when(response) {
                is DataResult.success -> {
                    Toast.makeText(this, " API success",Toast.LENGTH_SHORT).show()
                }
                is DataResult.failure -> {
                    Toast.makeText(this, " API failure",Toast.LENGTH_SHORT).show()
                }
            }
        })
        binding.fetch.setOnClickListener { view ->
            viewModel.makeAPICall()
        }
    }
}