package com.example.ovningkotling

import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.Toast
import androidx.appcompat.widget.Toolbar
import androidx.core.content.edit

class ProfileActivity : AppCompatActivity() {

    private lateinit var sharedPreferences: SharedPreferences
    private lateinit var nameEditText: EditText
    private lateinit var ageEditText: EditText
    private lateinit var emailEditText: EditText
    private lateinit var phoneEditText: EditText
    private lateinit var hasLicenseCheckBox: CheckBox
    private lateinit var genderRadioGroup: RadioGroup
    private lateinit var saveButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)

        // Setup toolbar
        val toolbar: Toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)

        // Initialize SharedPreferences
        sharedPreferences = getSharedPreferences("AppPreferences", MODE_PRIVATE)

        // Initialize views
        nameEditText = findViewById(R.id.nameEditText)
        ageEditText = findViewById(R.id.ageEditText)
        emailEditText = findViewById(R.id.emailEditText)
        phoneEditText = findViewById(R.id.phoneEditText)
        hasLicenseCheckBox = findViewById(R.id.hasLicenseCheckBox)
        genderRadioGroup = findViewById(R.id.genderRadioGroup)
        saveButton = findViewById(R.id.saveButton)

        // Load saved data
        loadSavedData()

        // Set click listener for save button
        saveButton.setOnClickListener {
            saveData()
            Toast.makeText(this, "Profile saved", Toast.LENGTH_SHORT).show()
        }
    }

    private fun loadSavedData() {
        nameEditText.setText(sharedPreferences.getString("name", ""))
        ageEditText.setText(sharedPreferences.getInt("age", 0).toString().takeIf { it != "0" } ?: "")
        emailEditText.setText(sharedPreferences.getString("email", ""))
        phoneEditText.setText(sharedPreferences.getString("phone", ""))
        hasLicenseCheckBox.isChecked = sharedPreferences.getBoolean("hasLicense", false)

        val savedGender = sharedPreferences.getString("gender", "")
        if (savedGender?.isNotEmpty() == true) {
            when (savedGender) {
                "Male" -> findViewById<RadioButton>(R.id.maleRadioButton).isChecked = true
                "Female" -> findViewById<RadioButton>(R.id.femaleRadioButton).isChecked = true
                "Other" -> findViewById<RadioButton>(R.id.otherRadioButton).isChecked = true
            }
        }
    }

    private fun saveData() {
        val name = nameEditText.text.toString()
        val age = ageEditText.text.toString().toIntOrNull() ?: 0
        val email = emailEditText.text.toString()
        val phone = phoneEditText.text.toString()
        val hasLicense = hasLicenseCheckBox.isChecked

        val selectedGenderId = genderRadioGroup.checkedRadioButtonId
        val gender = when (selectedGenderId) {
            R.id.maleRadioButton -> "Male"
            R.id.femaleRadioButton -> "Female"
            R.id.otherRadioButton -> "Other"
            else -> ""
        }

        sharedPreferences.edit {
            putString("name", name)
            putInt("age", age)
            putString("email", email)
            putString("phone", phone)
            putBoolean("hasLicense", hasLicense)
            putString("gender", gender)
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.main_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.menu_logout -> {
                // Clear login state
                sharedPreferences.edit {
                    putBoolean("isLoggedIn", false)
                }

                val intent = Intent(this, LoginActivity::class.java)
                startActivity(intent)
                finish()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    override fun onPause() {
        super.onPause()
        // Save data when app is paused
        saveData()
    }
}