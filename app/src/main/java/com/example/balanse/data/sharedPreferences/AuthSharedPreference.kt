package com.example.balanse.data.sharedPreferences

import android.content.Context
import android.content.SharedPreferences
import javax.inject.Inject

class AuthSharedPreference @Inject constructor(
    private val context: Context
) {
    private val sharedPreferences : SharedPreferences = context.getSharedPreferences("auth", Context.MODE_PRIVATE)
    private val editor : SharedPreferences.Editor = sharedPreferences.edit()

    fun saveFirstOpenAppStatus(isFirstOpenApp : Boolean){
        editor.putBoolean("isFirstOpenApp", isFirstOpenApp)
        editor.apply()
    }

    fun getFirstOpenAppStatus() : Boolean {
        return sharedPreferences.getBoolean("isFirstOpenApp", false)
    }
}