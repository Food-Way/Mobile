package com.example.foodway.model

import androidx.annotation.DrawableRes
import androidx.compose.ui.text.input.KeyboardType

data class Input(
    val inputLabel: String,
    @DrawableRes
    val icon: Int,
    val type: KeyboardType
)
