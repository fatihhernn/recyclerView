package com.bootcamp.odev3.ui.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.bootcamp.odev3.R
import com.bootcamp.odev3.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        val navController=findNavController(R.id.navHostFragment)
        val appBarConfiguration= AppBarConfiguration(setOf(
            R.id.restaurantFragment,
            R.id.foodsFragment,
            R.id.profileFragment
        ))

        binding.bottomNavigationView.setupWithNavController(navController)
        setupActionBarWithNavController(navController,appBarConfiguration)


    }
    override fun onSupportNavigateUp(): Boolean {
        return navController.navigateUp()|| super.onSupportNavigateUp()
    }

}