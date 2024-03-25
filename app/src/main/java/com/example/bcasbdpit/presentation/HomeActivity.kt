package com.example.bcasbdpit.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.example.bcasbdpit.R
import com.example.bcasbdpit.databinding.ActivityHomeBinding
import com.example.bcasbdpit.presentation.fragment.AdminFragment
import com.example.bcasbdpit.presentation.fragment.DashboardFragment
import com.example.bcasbdpit.presentation.fragment.InboxFragment
import com.example.bcasbdpit.presentation.fragment.MessageFragment
import com.example.bcasbdpit.utils.ConfirmationDialogueUtil
import com.example.bcasbdpit.utils.SharePrefHelper
import com.google.android.material.bottomnavigation.BottomNavigationView
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeActivity : AppCompatActivity() {

    private lateinit var binding: ActivityHomeBinding

    private lateinit var confirmationDialogueUtil: ConfirmationDialogueUtil

    private lateinit var sharePref: SharePrefHelper

    private val onNavigationItemSelectedListener =
        BottomNavigationView.OnNavigationItemSelectedListener { item ->
            when (item.itemId) {
                R.id.navigationHome -> {
                    replaceFragment(DashboardFragment())
                    return@OnNavigationItemSelectedListener true
                }

                R.id.navigationInbox -> {
                    replaceFragment(InboxFragment())
                    return@OnNavigationItemSelectedListener true
                }

                R.id.navigationAdmin -> {
                    replaceFragment(AdminFragment())
                    return@OnNavigationItemSelectedListener true
                }

                R.id.navigationMessage -> {
                    replaceFragment(MessageFragment())
                    return@OnNavigationItemSelectedListener true
                }

                R.id.navigationLogout -> {
                    showConfirmation()
                    return@OnNavigationItemSelectedListener true
                }
            }
            false
        }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        changeStatusBarColor()
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        confirmationDialogueUtil = ConfirmationDialogueUtil(this)
        sharePref = SharePrefHelper(this)


        binding.bottomNav.setOnNavigationItemSelectedListener(onNavigationItemSelectedListener)

        if (savedInstanceState == null) {
            binding.bottomNav.selectedItemId = R.id.navigationHome
        }
    }

    private fun showConfirmation() {
        val title = "Are you sure you want to exit?"
        val icon = R.drawable.baseline_admin_panel_settings_24


        confirmationDialogueUtil.showConfirmationDialog(
            title = title,
            icon = icon,
            onConfirm = {
                sharePref.clearDataPref()
                finish()
            },
            onCancel = {

            }
        )
    }

    private fun replaceFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragmentContainer, fragment)
            .commit()
    }

    private fun changeStatusBarColor() {
        // Check if the Android version is Lollipop or higher
        // Set the status bar color to your desired color
        window.statusBarColor = resources.getColor(R.color.dark_blue, theme)
    }
}