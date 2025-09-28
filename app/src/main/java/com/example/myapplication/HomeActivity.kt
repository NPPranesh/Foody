package com.example.myapplication

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
// Removed: all kotlinx.coroutines and java.io/net imports

import com.google.android.material.bottomnavigation.BottomNavigationView

class HomeActivity : AppCompatActivity() {

    // Only declare the UI elements you actually initialize and use
    private lateinit var postFoodButton: Button
    private lateinit var findFoodButton: Button
    private lateinit var home: ImageView
    private lateinit var add: ImageView
    private lateinit var search: ImageView
    private lateinit var orders: ImageView
    private lateinit var profile: ImageView


    // Removed: home, search, add, orders, settings variables

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_page) // make sure XML name matches

        // 1. Initialize Action Buttons
        postFoodButton = findViewById(R.id.post_food_button)
        findFoodButton = findViewById(R.id.find_food_button)
        home = findViewById(R.id.home)
        add = findViewById(R.id.add)
        search = findViewById(R.id.search)
        orders = findViewById(R.id.orders)
        profile = findViewById(R.id.profile)

        // Add action button listeners here
        search.setOnClickListener {
            val intent = Intent(this, ExploreActivity::class.java)
            startActivity(intent)
            finish()
        }
    }
}