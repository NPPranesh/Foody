package com.example.myapplication

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class CreateActivity : AppCompatActivity() {

    private lateinit var emailInput: EditText
    private lateinit var passwordInput: EditText
    private lateinit var loginButton: Button
    private lateinit var createAccountText: TextView

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // ✅ Make sure this matches your XML file (e.g. activity_login.xml)
        setContentView(com.example.myapplication.R.layout.create_account)

        emailInput = findViewById(com.example.myapplication.R.id.email_input)
        passwordInput = findViewById(com.example.myapplication.R.id.password_input)
        loginButton = findViewById(com.example.myapplication.R.id.submit_button)


        // ✅ Login button click
        loginButton.setOnClickListener {
            val email = emailInput.text.toString().trim()
            val password = passwordInput.text.toString().trim()

            if (email.isEmpty() || password.isEmpty()) {
                Toast.makeText(this, "Please fill in all fields", Toast.LENGTH_SHORT).show()
            } else {
                // TODO: You can add login logic here (e.g. connect to backend /login)
                Toast.makeText(this, "Login clicked", Toast.LENGTH_SHORT).show()
            }
        }

        // ✅ "Create New Account" click → Open RegisterActivity
        createAccountText.setOnClickListener {
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
        }
    }
}


