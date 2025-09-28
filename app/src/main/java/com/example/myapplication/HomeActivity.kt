package com.example.myapplication

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
// Removed: all kotlinx.coroutines and java.io/net imports

import com.google.android.material.bottomnavigation.BottomNavigationView

class HomeActivity : AppCompatActivity() {

    // Only declare the UI elements you actually initialize and use
    private lateinit var postFoodButton: Button
    private lateinit var findFoodButton: Button
    // Removed: home, search, add, orders, settings variables

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_page) // make sure XML name matches

        // 1. Initialize Action Buttons
        postFoodButton = findViewById(R.id.post_food_button)
        findFoodButton = findViewById(R.id.find_food_button)

        // 2. Initialize Bottom Navigation View
        val bottomNav = findViewById<BottomNavigationView>(R.id.bottom_navigation_bar)

        // 3. Handle Bottom Navigation Clicks (Correct Logic)
        bottomNav.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.home -> {
                    // Logic for Home (e.g., navigating to the Home Fragment/Screen)
                    true
                }
                R.id.add -> {
                    // Logic for Add/Post (e.g., navigating to CreatePostActivity)
                    true
                }
                R.id.search -> {
                    // Logic for Search (e.g., navigating to ExploreActivity)
                    true
                }
                R.id.orders -> {
                    // Logic for Orders
                    true
                }
                R.id.profile -> {
                    // Logic for Profile (your settings button replacement)
                    true
                }
                else -> false
            }
        }

        // Add action button listeners here
        postFoodButton.setOnClickListener {
            // Example: startActivity(Intent(this, CreatePostActivity::class.java))
        }
    }
}