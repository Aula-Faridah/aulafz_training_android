package com.example.bcasbdpit.presentation

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.bcasbdpit.R
import com.example.bcasbdpit.presentation.RegisterActivity.Companion.KEY_NAME
import com.example.bcasbdpit.databinding.ActivityProfileBinding

class ProfileActivity : AppCompatActivity() {

    private lateinit var binding : ActivityProfileBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityProfileBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val getName = intent.getStringExtra(KEY_NAME)
        binding.tvLabelName.text = "Nama    : ${getName}"

        binding.vComponentTopBar.tvTitle.text = "Profile Feature"
        binding.vComponentTopBar.ivBack.setOnClickListener {
            onBackPressed()
        }

        changeStatusBarColor()
        handleProfile()

    }

    private fun handleProfile(){
        val btnLogout = findViewById<Button>(R.id.btnLogout)

        btnLogout.setOnClickListener {
            handleLogout()
        }

    }

    private fun handleLogout(){
        val intent = Intent(this, LoginActivity::class.java)
        startActivity(intent)
        showToast("Logout Success!")
    }

    private fun showToast(message: String){
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()

    }

    private fun changeStatusBarColor() {
        // Check if the Android version is Lollipop or higher
        // Set the status bar color to your desired color
        window.statusBarColor = resources.getColor(R.color.dark_blue, theme)
    }
}