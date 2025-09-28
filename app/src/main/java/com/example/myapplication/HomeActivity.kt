package com.example.myapplication

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import org.json.JSONObject
import java.io.BufferedReader
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.net.HttpURLConnection
import java.net.URL
import com.example.myapplication.R

class HomeActivity : AppCompatActivity() {

    private lateinit var postfood: Button
    private lateinit var findfood: Button
    private lateinit var home: Button
    private lateinit var search: Button
    private lateinit var add: Button
    private lateinit var orders: Button
    private lateinit var settings: Button


    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_page) // make sure XML name matches





        postfood = findViewById(R.id.post_food_button)
        findfood = findViewById(R.id.find_food_button)
        home = findViewById(R.id.home)
        search = findViewById(R.id.search)
        add = findViewById(R.id.add)
        orders = findViewById(R.id.orders)
        settings = findViewById(R.id.profile)




    }
}