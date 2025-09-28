/*
package com.example.myapplication

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.*
import android.content.Intent
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

class LoginActivity : AppCompatActivity() {

    private lateinit var emailInput: EditText
    private lateinit var passwordInput: EditText
    private lateinit var signinButton: Button

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.login) // make sure XML name matches



        emailInput = findViewById(R.id.email_input)
        passwordInput = findViewById(R.id.password_input)
        signinButton = findViewById(R.id.sign_in_button)

        signinButton.setOnClickListener {
            val email = emailInput.text.toString().trim()
            val password = passwordInput.text.toString().trim()

            if (email.isEmpty() ||password.isEmpty()) {
                Toast.makeText(this, "⚠️ Please fill all fields", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            val userJson = JSONObject().apply {
                put("email", email)
                put("password", password)
            }

            registerUser(userJson)
        }
    }

    private fun registerUser(userJson: JSONObject) {
        // disable button while sending request
        signinButton.isEnabled = false
        signinButton.text = "Signing in..."
        "✅ Signed in Successfully!"
        val intent = Intent(this@LoginActivity, HomeActivity::class.java)
        startActivity(intent)
        finish()

        CoroutineScope(Dispatchers.IO).launch {
            */
/*val result = try {
                val url = URL("http://10.0.2.2:8080/register") // change IP if using real device
                val connection = url.openConnection() as HttpURLConnection
                connection.requestMethod = "POST"
                connection.setRequestProperty("Content-Type", "application/json")
                connection.doOutput = true

                val outputWriter = OutputStreamWriter(connection.outputStream)
                outputWriter.write(userJson.toString())
                outputWriter.flush()
                outputWriter.close()

                val responseCode = connection.responseCode
                val reader = BufferedReader(InputStreamReader(connection.inputStream))
                val response = reader.readText()
                reader.close()

                connection.disconnect()*//*


                if (true) {
                    "✅ Signed in Successfully!"
                    val intent = Intent(this@LoginActivity, HomeActivity::class.java)
                    startActivity(intent)
                    finish()
                } else {
                    "❌ Failed to register (Error: $)"
                }

            */
/*} catch (e: Exception) {
                "⚠️ Error: ${e.localizedMessage}"
            }*//*


            */
/*runOnUiThread {
                Toast.makeText(this@LoginActivity, result, Toast.LENGTH_LONG).show()
                signinButton.isEnabled = true
                signinButton.text = "Sign in"

                if (result.startsWith("✅")) clearFields()
            }*//*

        }
    }

    private fun clearFields() {
        emailInput.text.clear()
        passwordInput.text.clear()
    }
}*/
package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class LoginActivity : AppCompatActivity() {

    // You can keep these declarations
    private lateinit var emailInput: EditText
    private lateinit var passwordInput: EditText
    private lateinit var signinButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.login) // This should match your XML file name

        // Find your views by their ID from the login.xml file
        emailInput = findViewById(R.id.email_input)
        passwordInput = findViewById(R.id.password_input)
        signinButton = findViewById(R.id.sign_in_button)

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

                // This prevents the user from going back to the login screen
                finish()

            } else {
                // If fields are empty, show an error message
                Toast.makeText(this, "Please enter email and password", Toast.LENGTH_SHORT).show()
            }
        }
    }
}