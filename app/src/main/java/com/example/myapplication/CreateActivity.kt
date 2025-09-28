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
    private lateinit var nameinput : EditText
    private lateinit var passwordInput: EditText
    private lateinit var submitButton: Button

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // ✅ Make sure this matches your XML file (e.g. activity_login.xml)
        setContentView(R.layout.create_account)
        nameinput = findViewById(R.id.name_input)
        emailInput = findViewById(R.id.email_input)
        passwordInput = findViewById(R.id.password_input)
        submitButton = findViewById(R.id.submit_button)

        // ✅ Login button click
        submitButton.setOnClickListener {
            val email = emailInput.text.toString().trim()
            val password = passwordInput.text.toString().trim()
            val name = nameinput.text.toString().trim()

            if (email.isEmpty() || password.isEmpty()) {
                Toast.makeText(this, "Please fill in all fields", Toast.LENGTH_SHORT).show()
            } else {
                // TODO: You can add login logic here (e.g. connect to backend /login)
                Toast.makeText(this, "Login clicked", Toast.LENGTH_SHORT).show()
                val intent = Intent(this, HomeActivity::class.java)
                val NAME_KEY = "EXTRA_NAME"
                intent.putExtra(NAME_KEY, name)
                startActivity(intent)
            }
        }
    }
}


