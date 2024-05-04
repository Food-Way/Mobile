package com.example.foodway.model

import androidx.compose.ui.text.input.KeyboardType
import com.example.foodway.R

object CustomerInputManager {
    val personalCustomerInputInfos = listOf(
        InputInfo(
            inputLabel = R.string.name,
            icon = R.drawable.person_icon,
            type = KeyboardType.Text
        ),
        InputInfo(
            inputLabel = R.string.last_name_costumer,
            icon = R.drawable.person_icon,
            type = KeyboardType.Text
        ),
        InputInfo(
            inputLabel = R.string.cpf_costumer,
            icon = R.drawable.badge_icon,
            type = KeyboardType.Email
        ),
        InputInfo(
            inputLabel = R.string.email,
            icon = R.drawable.email_icon,
            type = KeyboardType.Password
        ),
        InputInfo(
            inputLabel = R.string.password,
            icon = R.drawable.lock_icon,
            type = KeyboardType.Password
        ),
        InputInfo(
            inputLabel = R.string.conf_password,
            icon = R.drawable.lock_icon,
            type = KeyboardType.Password
        )
    )

    val profileCustomerInputInfos = listOf(
        InputInfo(
            inputLabel = R.string.name,
            icon = R.drawable.person_icon,
            type = KeyboardType.Text
        ),
        InputInfo(
            inputLabel = R.string.bio,
            icon = R.drawable.stars,
            type = KeyboardType.Text
        ),
    )
}