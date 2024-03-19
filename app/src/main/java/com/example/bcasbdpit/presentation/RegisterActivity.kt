package com.example.bcasbdpit.presentation

import android.content.Intent
import android.os.Bundle
import android.text.InputType
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.bcasbdpit.R
import com.example.bcasbdpit.databinding.ActivityRegisterBinding

class RegisterActivity : AppCompatActivity(){
    private lateinit var binding : ActivityRegisterBinding
    private var defaultPassVisibility = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegisterBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.vComponentTopBar.tvTitle.text = "Back"
        binding.vComponentTopBar.ivBack.setOnClickListener {
            onBackPressed()
        }

        binding.ivInvisible.setOnClickListener {
            defaultPassVisibility = !defaultPassVisibility

            if (defaultPassVisibility){
                binding.ivInvisible.setImageResource(R.drawable.baseline_blur_on_24)
                binding.password.inputType = InputType.TYPE_CLASS_TEXT
            } else {
                binding.ivInvisible.setImageResource(R.drawable.baseline_blur_off_24)
                binding.password.inputType = InputType.TYPE_CLASS_TEXT or InputType.TYPE_TEXT_VARIATION_PASSWORD

            }
        }

        binding.ivInvisible2.setOnClickListener {
            defaultPassVisibility = !defaultPassVisibility

            if (defaultPassVisibility){
                binding.ivInvisible2.setImageResource(R.drawable.baseline_blur_on_24)
                binding.reenterPassword.inputType = InputType.TYPE_CLASS_TEXT
            } else {
                binding.ivInvisible2.setImageResource(R.drawable.baseline_blur_off_24)
                binding.reenterPassword.inputType = InputType.TYPE_CLASS_TEXT or InputType.TYPE_TEXT_VARIATION_PASSWORD

            }
        }

        handleRegister()
        changeStatusBarColor()
    }

    private fun handleRegister(){

//        val btnRegister = findViewById<Button>(R.id.btnRegister)
//        val etUsername = findViewById<EditText>(R.id.username)
//        val etPassword = findViewById<EditText>(R.id.password)
//        val etReenterPass = findViewById<EditText>(R.id.reenterPassword)

        val etUsername = binding.username
        val etPassword = binding.password
        val etReenterPass = binding.reenterPassword

        val usernameValue = etUsername.text
        val passwordValue = etPassword.text
        val reenterPass = etReenterPass.text


        binding.btnRegister.setOnClickListener {
            if (usernameValue.isEmpty() || passwordValue.isEmpty() || reenterPass.isEmpty()){
//                Toast.makeText(this, "Please complete all fields!", Toast.LENGTH_SHORT).show()
                showToast("Please complete all fields!")
            } else {
//                showToast("${usernameValue} already registered!")
//                handleLogin(usernameValue.toString())
                intentTo(LoginActivity::class.java, usernameValue.toString())
            }
//            val intent = Intent(this, ProfileActivity::class.java)

//            intent.putExtra(KEY_NAME, usernameValue)
        }
    }

//    private fun handleLogin(usernameValue){
////        val intent = Intent(this, LoginActivity::class.java)
//        intentTo(LoginActivity::class.java)
//        intent.putExtra(KEY_NAME, usernameValue)
//
//        startActivity(intent)
//        showToast("Registered. Please Login")
//    }

    private fun showToast(message: String){
        Toast.makeText(this, message,Toast.LENGTH_SHORT).show()

    }

    companion object {
        const val KEY_NAME = "key_name"
    }

    private fun intentTo(clazz: Class<*>,name:String){
        val intent = Intent(this, clazz)
        intent.putExtra(KEY_NAME,name)
        startActivity(intent)

    }

    private fun changeStatusBarColor() {
        // Check if the Android version is Lollipop or higher
        // Set the status bar color to your desired color
        window.statusBarColor = resources.getColor(R.color.dark_blue, theme)
    }
}