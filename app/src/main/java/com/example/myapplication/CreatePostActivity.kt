package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.button.MaterialButton
import com.google.android.material.textfield.TextInputEditText
import android.net.Uri
import androidx.activity.result.contract.*

class CreatePostActivity : AppCompatActivity() {
    private lateinit var imageView: ImageView // The ImageView to display the result

    private val galleryLauncher = registerForActivityResult(
        ActivityResultContracts.GetContent() // Contract for picking a piece of content (like an image)
    ) { uri: Uri? ->
        // This code runs when the user successfully picks an image.
        if (uri != null) {
            imageView.setImageURI(uri) // Display the image in the ImageView
            // Optionally, store the URI for later use (uploading, etc.)
        }
    }

    // Declare all interactive form elements
    private lateinit var backButton: ImageView
    private lateinit var titleInput: TextInputEditText
    private lateinit var descriptionInput: TextInputEditText
    private lateinit var pickupTimeInput: TextInputEditText
    private lateinit var instructionsInput: TextInputEditText
    private lateinit var locationInput: TextInputEditText
    private lateinit var confirmButton: MaterialButton
    private lateinit var addimage: ImageView
    private var currentImageCount = 0
    private var MAX_IMAGE_COUNT = 5

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // Ensure this layout name matches your XML file name
        setContentView(R.layout.create_post)

        // 1. Initialize Views by ID
        // Note: The back_button is an ImageView, not a Button, but is clickable.
        backButton = findViewById(R.id.back_button)
        titleInput = findViewById(R.id.title_input)
        descriptionInput = findViewById(R.id.description_input)
        pickupTimeInput = findViewById(R.id.pickup_time_input)
        instructionsInput = findViewById(R.id.instructions_input)
        locationInput = findViewById(R.id.location_input)
        confirmButton = findViewById(R.id.confirm_button)
        addimage = findViewById(R.id.add_image)

        // 2. Set Click Listeners

        // Handle Back Button click (Navigates up the stack)
        backButton.setOnClickListener {
            onBackPressedDispatcher.onBackPressed()
        }

        // Handle Confirm Button click (Submits the form)
        confirmButton.setOnClickListener {
            submitPost()
        }
        addimage.setOnClickListener {
            if (currentImageCount < MAX_IMAGE_COUNT) {
                // Launch the gallery chooser
                galleryLauncher.launch("image/*")
            } else {
                // Show an immediate error message
                Toast.makeText(
                    this,
                    "⚠️ Maximum of $MAX_IMAGE_COUNT images reached.",
                    Toast.LENGTH_SHORT
                ).show()
            }
        }
    }

    /**
     * Gathers form data, validates it, and processes the submission.
     */
    private fun submitPost() {
        val title = titleInput.text.toString().trim()
        val description = descriptionInput.text.toString().trim()
        val pickupTime = pickupTimeInput.text.toString().trim()
        val location = locationInput.text.toString().trim()

        // Simple validation check
        if (title.isEmpty() || description.isEmpty() || location.isEmpty() || pickupTime.isEmpty() || currentImageCount == 0) {
            Toast.makeText(this, "Please fill in Title, Description, and Location and add atleast 1 image.", Toast.LENGTH_LONG).show()
            return
        }

        // --- Simulated Post Submission ---
        // In a real app, you would disable the button, show a progress spinner,
        // and make an asynchronous network request to your server here.

        Toast.makeText(this, "Posting Food Donation...", Toast.LENGTH_SHORT).show()

        // Simulate success and navigate back to the Home Screen
        confirmButton.postDelayed({
            Toast.makeText(this, "Post Created Successfully!", Toast.LENGTH_LONG).show()

            // Navigate back to the main activity and close this screen
            val intent = Intent(this, HomeActivity::class.java).apply {
                flags = Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_SINGLE_TOP
            }
            startActivity(intent)
            finish()

        }, 1500) // 1.5 second delay simulation
    }
}