package com.example.myapplication

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class ExploreActivity : AppCompatActivity() {
    private lateinit var home: ImageView
    private lateinit var add: ImageView
    private lateinit var search: ImageView
    private lateinit var orders: ImageView
    private lateinit var profile: ImageView

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // ✅ Make sure this matches your XML file (e.g. activity_login.xml)
        setContentView(R.layout.explore)

        home = findViewById(R.id.home)
        add = findViewById(R.id.add)
        search = findViewById(R.id.search)
        orders = findViewById(R.id.orders)
        profile = findViewById(R.id.profile)


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
    }
}


