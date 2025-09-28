//package com.example.myapplication
//
//import android.annotation.SuppressLint
//import android.content.Intent
//import android.os.Bundle
//import android.widget.Button
//import androidx.appcompat.app.AppCompatActivity
//// Removed: all kotlinx.coroutines and java.io/net imports
//
//import com.google.android.material.bottomnavigation.BottomNavigationView
//
//class HomeActivity : AppCompatActivity() {
//
//    // Only declare the UI elements you actually initialize and use
//    private lateinit var postFoodButton: Button
//    private lateinit var findFoodButton: Button
//    private lateinit var binding: MainPageBinding
//
//
//    // Removed: home, search, add, orders, settings variables
//
//    @SuppressLint("MissingInflatedId")
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContentView(R.layout.main_page) // make sure XML name matches
//
//        // 1. Initialize Action Buttons
//        postFoodButton = findViewById(R.id.post_food_button)
//        findFoodButton = findViewById(R.id.find_food_button)
//
//        // 2. Initialize Bottom Navigation View
//        val bottomNav = findViewById<BottomNavigationView>(R.id.bottom_navigation_bar)
//
//        // 3. Handle Bottom Navigation Clicks (Correct Logic)
//        bottomNav.setOnItemSelectedListener { item ->
//            when (item.itemId) {
//                R.id.home -> {
//                    // Logic for Home (e.g., navigating to the Home Fragment/Screen)
//                    true
//                }
//                R.id.add -> {
//                    // Logic for Add/Post (e.g., navigating to CreatePostActivity)
//                    true
//                }
//                R.id.search -> {
//                    // Logic for Search (e.g., navigating to ExploreActivity)
//                    true
//                }
//                R.id.orders -> {
//                    // Logic for Orders
//                    true
//                }
//                R.id.profile -> {
//                    // Logic for Profile (your settings button replacement)
//                    true
//                }
//                else -> false
//            }
//        }
//
//        // Add action button listeners here
//        postFoodButton.setOnClickListener {
//            // Example: startActivity(Intent(this, CreatePostActivity::class.java))
//        }
//        // In HomeActivity.kt, inside the onCreate method
//
//// Assume your search icon ImageButton has the ID 'buttonSearch'
//        binding.buttonSearch.setOnClickListener {
//
//            // This intent opens your new ExploreActivity screen
//            val intent = Intent(this, ExploreActivity::class.java)
//            startActivity(intent)
//        }
//    }
//}
// In HomeActivity.kt


package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.myapplication.databinding.MainPageBinding // The correct binding import

class HomeActivity : AppCompatActivity() {

    // This is the ONLY variable you need to declare for your views
    private lateinit var binding: MainPageBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // --- THIS IS THE CRITICAL FIX ---
        // 1. Initialize the binding object by "inflating" your XML layout
        binding = MainPageBinding.inflate(layoutInflater)

        // 2. Set the content view by using the binding's root view
        setContentView(binding.root)


        // --- YOU NO LONGER NEED findViewById. ACCESS EVERYTHING THROUGH 'binding' ---

        // Set listeners for your main action buttons
        // Make sure the IDs in main_page.xml are 'postFoodButton' and 'findFoodButton'
        binding.postFoodButton.setOnClickListener {
            val intent = Intent(this, CreatePostActivity::class.java)
            startActivity(intent)
        }

        binding.findFoodButton.setOnClickListener {
            // Logic to find food can go here, maybe navigate to ExploreActivity
            val intent = Intent(this, ExploreActivity::class.java)
            startActivity(intent)
        }

        // Set the listener for your Bottom Navigation View
        // Make sure the ID in main_page.xml is 'bottomNav'
        binding.bottomNav.setOnItemSelectedListener { item ->
            when (item.itemId) {
                // IMPORTANT: These IDs (e.g., R.id.home, R.id.search) must match the
                // IDs of the menu items you created for your bottom navigation.

                R.id.search -> {
                    val intent = Intent(this, ExploreActivity::class.java)
                    startActivity(intent)
                    true
                }
                R.id.profile -> {
                    // val intent = Intent(this, ProfileActivity::class.java)
                    // startActivity(intent)
                    true
                }
                // Add cases for your other navigation items here (e.g., home, add)

                else -> false
            }
        }
    }
}