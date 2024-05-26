package com.example.foodway.domain.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.ui.text.input.KeyboardType

data class InputInfo(
    @StringRes
    val inputLabel: Int,
    @DrawableRes
    val icon: Int,
    val type: KeyboardType,
)
