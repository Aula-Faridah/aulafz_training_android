package com.example.bcasbdpit.presentation

import android.content.Intent
import android.os.Bundle
import android.text.InputType
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.bcasbdpit.R
import com.example.bcasbdpit.presentation.RegisterActivity.Companion.KEY_NAME
import com.example.bcasbdpit.databinding.ActivityLoginBinding
import com.example.bcasbdpit.utils.SharePrefHelper
import java.util.UUID

class LoginActivity : AppCompatActivity(), PlayMusic {
    private lateinit var binding: ActivityLoginBinding

    private lateinit var sharePref: SharePrefHelper

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        sharePref = SharePrefHelper(this)


        binding.cbPassword.setOnClickListener {
            val visibilityPass = binding.cbPassword

            if (visibilityPass.isChecked) {
                binding.passwordLog.inputType = InputType.TYPE_CLASS_TEXT
            } else {
                binding.passwordLog.inputType =
                    InputType.TYPE_CLASS_TEXT or InputType.TYPE_TEXT_VARIATION_PASSWORD
            }
        }

        checkToken()
        handleLogin()
        changeStatusBarColor()
    }

    private fun checkToken(){
        val getToken = sharePref.getToken()
        if(getToken.isNotEmpty() ){
            intentTo(HomeActivity::class.java)
        }
    }

    private fun handleLogin() {
//        val btnLogin = findViewById<Button>(R.id.btnLogin)
//        val tvRegister = findViewById<TextView>(R.id.tvRegister)
//        val etUsername = findViewById<EditText>(R.id.usernameLog)
//        val etPassword = findViewById<EditText>(R.id.passwordLog)

        val etUsername = binding.usernameLog
        val etPassword = binding.passwordLog

        val usernameValue = etUsername.text
        val passwordValue = etPassword.text

        binding.btnLogin.setOnClickListener {
            if (usernameValue.isEmpty() || passwordValue.isEmpty()) {
//                Toast.makeText(this, "Please complete all fields!", Toast.LENGTH_SHORT).show()
                showToast("Please complete all fields!")
            } else {
                val token = UUID.randomUUID().toString()
                sharePref.saveToken(token)
//                sharePref.saveName(usernameValue)

                showToast("${usernameValue} successfully logged in!")
//                handleProfile()
//                intentTo(ProfileActivity::class.java, usernameValue.toString())
//                intentTo(TransactionActivity::class.java, usernameValue.toString())
                intentTo(HomeActivity::class.java, usernameValue.toString())
            }
        }

        binding.tvRegister.setOnClickListener {
            handleRegister()
        }
    }

    private fun handleRegister() {
//        val intent = Intent(this, RegisterActivity::class.java)
        intentTo(RegisterActivity::class.java)
//        finish()
    }

    private fun handleProfile() {
//        val intent = Intent(this, ProfileActivity::class.java)
        intentTo(ProfileActivity::class.java)
        startActivity(intent)
        showToast("Login Success!")
//        finish()

    }

    private fun showToast(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }
    private fun intentTo(clazz: Class<*>, name: String = "") {
        val intent = Intent(this, clazz)
        if (name.isEmpty().not()) {
            intent.putExtra(KEY_NAME, name)
        }
        startActivity(intent)
    }

    private fun changeStatusBarColor() {
        // Check if the Android version is Lollipop or higher
        // Set the status bar color to your desired color
        window.statusBarColor = resources.getColor(R.color.dark_blue, theme)
    }

    override fun play() {
        TODO("Not yet implemented")
    }

    override fun stop() {
        TODO("Not yet implemented")
    }

}