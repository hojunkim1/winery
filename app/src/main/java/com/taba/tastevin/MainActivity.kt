package com.taba.tastevin

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.taba.tastevin.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setSupportActionBar(binding.mainToolbar)

        val navHostFragment = supportFragmentManager.findFragmentById(
            R.id.main_nav_host
        ) as NavHostFragment
        navController = navHostFragment.navController

        val bottomNavigationView = binding.mainNavView
        bottomNavigationView.setupWithNavController(navController)

        val appBarConfiguration = AppBarConfiguration(
            setOf(R.id.home_fragment, R.id.bookmark_fragment)
        )
        setupActionBarWithNavController(navController, appBarConfiguration)

        // dark mode X
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
    }
}