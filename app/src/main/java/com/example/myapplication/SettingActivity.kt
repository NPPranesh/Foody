package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.switchmaterial.SwitchMaterial
import android.widget.TextView // Used for all the link TextViews

class SettingActivity : AppCompatActivity() {

    // Declare interactive elements
    private lateinit var switchDarkTheme: SwitchMaterial
    private lateinit var switchNotifications: SwitchMaterial
    private lateinit var settingLogOut: TextView
    private lateinit var settingProfile: TextView
    private lateinit var settingAboutUs: TextView
    private lateinit var settingPrivacyPolicy: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // Ensure this layout name matches your XML file name
        setContentView(R.layout.settings)

        // 1. Initialize Views
        switchDarkTheme = findViewById(R.id.switch_dark_theme)
        switchNotifications = findViewById(R.id.switch_notifications)
        settingLogOut = findViewById(R.id.setting_log_out)
        settingProfile = findViewById(R.id.setting_profile)
        settingAboutUs = findViewById(R.id.setting_about_us)
        settingPrivacyPolicy = findViewById(R.id.setting_privacy_policy)


        // 2. Set Listeners for Toggles

        switchDarkTheme.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked) {
                Toast.makeText(this, "Dark Theme ON (Needs App Restart)", Toast.LENGTH_SHORT).show()
                // In a real app, save this state and apply a new theme (e.g., AppCompatDelegate.setDefaultNightMode)
            } else {
                Toast.makeText(this, "Dark Theme OFF", Toast.LENGTH_SHORT).show()
            }
        }

        switchNotifications.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked) {
                Toast.makeText(this, "Notifications Enabled", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this, "Notifications Disabled", Toast.LENGTH_SHORT).show()
            }
        }


        // 3. Set Listeners for Navigation Links

        settingProfile.setOnClickListener {
            Toast.makeText(this, "Navigating to Profile Settings...", Toast.LENGTH_SHORT).show()
            // Example Navigation: startActivity(Intent(this, ProfileActivity::class.java))
        }

        settingAboutUs.setOnClickListener {
            Toast.makeText(this, "Showing About Us info...", Toast.LENGTH_SHORT).show()
            // Example: launch WebView or About Us Activity
        }

        settingPrivacyPolicy.setOnClickListener {
            Toast.makeText(this, "Showing Privacy Policy...", Toast.LENGTH_SHORT).show()
            // Example: launch browser with policy URL
        }

        // 4. Log Out Action (Crucial)
        settingLogOut.setOnClickListener {
            Toast.makeText(this, "Logging Out...", Toast.LENGTH_LONG).show()

            // Perform necessary cleanup (clear shared preferences/session tokens)

            // Navigate to LoginActivity and clear the entire activity stack
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
            finish()
        }
    }
}