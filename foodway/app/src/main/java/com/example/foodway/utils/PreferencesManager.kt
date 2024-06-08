package com.example.foodway.utils

import android.content.Context
import android.content.SharedPreferences

class PreferencesManager(context : Context) {
    private val sharedPreferences: SharedPreferences =
        context.getSharedPreferences("user_preferences", Context.MODE_PRIVATE)

    fun saveAuthenticatedData(
        key: String,
        value: Any
    ) {
        val editor = sharedPreferences.edit()

        when (value) {
            is String -> editor.putString(key, value)
            is Int -> editor.putInt(key, value)
            is Long -> editor.putLong(key, value)
            is Float -> editor.putFloat(key, value)
            is Boolean -> editor.putBoolean(key, value)
            else -> throw IllegalArgumentException("Unsupported type")
        }

        editor.apply()
    }

    fun getSavedData(key: String, defaultValue: String = ""): String{
        return sharedPreferences.getString(key, defaultValue) ?: defaultValue
    }

    fun clearData() {
        val editor = sharedPreferences.edit()
        editor.clear()
        editor.apply()
    }
}