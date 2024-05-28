package com.example.foodway.utils

import android.content.Context
import android.content.SharedPreferences
import java.util.UUID

class PreferencesManager(context : Context) {
    private val sharedPreferences: SharedPreferences =
        context.getSharedPreferences("user_preferences", Context.MODE_PRIVATE)

    fun saveAuthenticatedData(
        id: UUID
    ) {
        sharedPreferences
            .edit()
            .putString("id", id.toString())
            .apply()
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