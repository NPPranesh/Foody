package com.example.myapp

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
import com.example.myapplication.R.id.name_input
import com.example.myapplication.R.id.phone_input

class RegisterActivity : AppCompatActivity() {

    private lateinit var nameInput: EditText
    private lateinit var emailInput: EditText
    private lateinit var phoneInput: EditText
    private lateinit var passwordInput: EditText
    private lateinit var submitButton: Button

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.login) // make sure XML name matches


        nameInput = findViewById(name_input)
        emailInput = findViewById(R.id.email_input)
        phoneInput = findViewById(phone_input)
        passwordInput = findViewById(R.id.password_input)
        submitButton = findViewById(R.id.submit_button)

        submitButton.setOnClickListener {
            val name = nameInput.text.toString().trim()
            val email = emailInput.text.toString().trim()
            val phone = phoneInput.text.toString().trim()
            val password = passwordInput.text.toString().trim()

            if (name.isEmpty() || email.isEmpty() || phone.isEmpty() || password.isEmpty()) {
                Toast.makeText(this, "⚠️ Please fill all fields", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            val userJson = JSONObject().apply {
                put("name", name)
                put("email", email)
                put("phone", phone)
                put("password", password)
            }

            registerUser(userJson)
        }
    }

    private fun registerUser(userJson: JSONObject) {
        // disable button while sending request
        submitButton.isEnabled = false
        submitButton.text = "Registering..."

        CoroutineScope(Dispatchers.IO).launch {
            val result = try {
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

                connection.disconnect()

                if (responseCode == 200) {
                    "✅ Registered successfully!"
                } else {
                    "❌ Failed to register (Error: $responseCode)"
                }

            } catch (e: Exception) {
                "⚠️ Error: ${e.localizedMessage}"
            }

            runOnUiThread {
                Toast.makeText(this@RegisterActivity, result, Toast.LENGTH_LONG).show()
                submitButton.isEnabled = true
                submitButton.text = "Submit"

                if (result.startsWith("✅")) clearFields()
            }
        }
    }

    private fun clearFields() {
        nameInput.text.clear()
        emailInput.text.clear()
        phoneInput.text.clear()
        passwordInput.text.clear()
    }
}