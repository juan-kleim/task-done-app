package com.juanpacheco.apptaskdone

import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.NavigationUI.setupWithNavController
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.juanpacheco.apptaskdone.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private val binding by lazy{
        ActivityMainBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        val bottomNavigationView = findViewById<BottomNavigationView>(R.id.bottomNavigationView)

        val navHostFragment = supportFragmentManager
            .findFragmentById(R.id.nav_host_fragment) as NavHostFragment?

        if (navHostFragment != null) {
            val navController = navHostFragment.navController

            setupWithNavController(bottomNavigationView, navController)

            bottomNavigationView.setOnItemSelectedListener { item: MenuItem ->
                val itemId = item.itemId
                val currentDestination =
                    if (navController.currentDestination != null) navController.currentDestination!!.id else -1

                if (currentDestination != itemId) {
                    navController.popBackStack(itemId, false)
                    navController.navigate(itemId)
                }
                true
            }
        }
    }
}