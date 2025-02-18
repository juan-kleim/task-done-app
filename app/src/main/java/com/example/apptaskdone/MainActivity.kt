package com.example.apptaskdone

import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.NavigationUI.setupWithNavController
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val bottomNavigationView = findViewById<BottomNavigationView>(R.id.bottomNavigationView)

        // Garante que o NavController seja recuperado corretamente
        val navHostFragment = supportFragmentManager
            .findFragmentById(R.id.nav_host_fragment) as NavHostFragment?

        if (navHostFragment != null) {
            val navController = navHostFragment.navController

            // Configura o BottomNavigationView para funcionar com o NavController
            setupWithNavController(bottomNavigationView, navController)

            // Configura a navegação personalizada
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