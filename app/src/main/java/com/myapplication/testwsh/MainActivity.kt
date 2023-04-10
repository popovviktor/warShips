package com.myapplication.testwsh

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.findNavController
import androidx.navigation.ui.setupWithNavController
import com.myapplication.data.api.models.FindGamesResponse
import com.myapplication.data.utils.NetworkResult
import com.myapplication.testwsh.databinding.ActivityMainBinding
import com.myapplication.testwsh.screens.RegisterFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private val vm:MainViewModel by viewModels()
    private val vmautologin: ViewModelAutoLogin by viewModels()
    private val vmreg:ViewModelRegisterLoginToken by viewModels()
    lateinit var binding:ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val navController = findNavController(R.id.nav_host)
        val bottomnav = binding.bottomNavMenu
        bottomnav.setupWithNavController(navController)
        navController.popBackStack()
        navController.navigate(R.id.registerFragment)
        bottomnav.setOnItemSelectedListener {
            when(it.itemId) {
                (R.id.nav_home) -> {
                    navController.navigate(R.id.homeFragment)
                }
                (R.id.nav_chat) -> {
                    navController.navigate(R.id.nav_chat)
                }
                (R.id.nav_profile) -> {
                    navController.navigate(R.id.nav_profile)
                }
                else -> {}
            }; false
        }



    }
}