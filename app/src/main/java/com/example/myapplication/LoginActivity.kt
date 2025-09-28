package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class LoginActivity : AppCompatActivity() {

    // You can keep these declarations
    private lateinit var emailInput: EditText
    private lateinit var passwordInput: EditText
    private lateinit var signinButton: Button
    private lateinit var createaccount: TextView
    private lateinit var forgetpassword: TextView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.login) // This should match your XML file name

        // Find your views by their ID from the login.xml file
        emailInput = findViewById(R.id.email_input)
        passwordInput = findViewById(R.id.password_input)
        signinButton = findViewById(R.id.sign_in_button)
        createaccount = findViewById(R.id.create_account_link)
        forgetpassword = findViewById(R.id.forgot_password_link)

        createaccount.setOnClickListener {
            val intent = Intent(this, CreateActivity::class.java)
            startActivity(intent)
        }

        // Set the click listener for your sign-in button
        signinButton.setOnClickListener {
            val email = emailInput.text.toString().trim()
            val password = passwordInput.text.toString().trim()

            // A simple check to see if the fields are not empty
            if (email.isNotEmpty() && password.isNotEmpty()) {

                // If they are not empty, navigate to the HomeActivity
                Toast.makeText(this, "Sign In Successful!", Toast.LENGTH_SHORT).show()

                val intent = Intent(this, HomeActivity::class.java)
                startActivity(intent)

            } else {
                // If fields are empty, show an error message
                Toast.makeText(this, "Please enter email and password", Toast.LENGTH_SHORT).show()
            }
        }
    }
}