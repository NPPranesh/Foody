package com.example.myapplication
import com.example.myapplication.CreateActivity
import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
// Removed: all kotlinx.coroutines and java.io/net imports

import com.google.android.material.bottomnavigation.BottomNavigationView
import org.w3c.dom.Text

class HomeActivity : AppCompatActivity() {

    // Only declare the UI elements you actually initialize and use
    private lateinit var postFoodButton: Button
    private lateinit var findFoodButton: Button
    private lateinit var home: ImageView
    private lateinit var add: ImageView
    private lateinit var search: ImageView
    private lateinit var orders: ImageView
    private lateinit var profile: ImageView
    private lateinit var greet: TextView


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
        greet = findViewById(R.id.greeting_text)
        val NAME_KEY = "EXTRA_NAME"
        val name = intent.getStringExtra(NAME_KEY)

        greet.text = "Hello, "+name+"!"
        // Add action button listeners here
        search.setOnClickListener {
            val intent = Intent(this, ExploreActivity::class.java)
            startActivity(intent)
        }
        home.setOnClickListener {
            val intent = Intent(this, HomeActivity::class.java)
            startActivity(intent)
        }
        add.setOnClickListener {
            val intent = Intent(this, CreatePostActivity::class.java)
            startActivity(intent)
        }
        profile.setOnClickListener {
            val intent = Intent(this, SettingActivity::class.java)
            startActivity(intent)
        }
        postFoodButton.setOnClickListener {
            val intent = Intent(this, CreatePostActivity::class.java)
            startActivity(intent)
        }
        findFoodButton.setOnClickListener {
            val intent = Intent(this, ExploreActivity::class.java)
            startActivity(intent)
        }
    }
}