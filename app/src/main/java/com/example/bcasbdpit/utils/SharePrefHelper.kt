package com.example.bcasbdpit.utils

import android.content.Context
import android.content.SharedPreferences
import android.text.Editable

class SharePrefHelper(context: Context) {

    private val sharedPref: SharedPreferences =
        context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE)

    fun saveToken(token: String) {
        sharedPref.edit().putString(TOKEN_KEY, token).apply()
    }

    fun getToken(): String {
        return sharedPref.getString(TOKEN_KEY, null) ?: ""
    }

    fun clearDataPref() {
        val editor = sharedPref.edit()
        editor.clear()
        editor.apply()
    }

//    fun saveName(uname: Editable){
//        sharedPref.edit().putString(KEY_NAME, uname.toString()).apply()
//    }

    companion object {
        const val PREF_NAME = "APP"
        const val TOKEN_KEY = ""
//        const val KEY_NAME = ""
    }
}