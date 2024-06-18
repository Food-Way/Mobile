package com.example.foodway.domain.model

import androidx.compose.ui.text.input.KeyboardType
import com.example.foodway.R

object EstablishmentInputManager {
    val personalEstablishmentInputInfos = listOf(
        InputInfo(
            inputLabel = R.string.fantasy_name,
            icon = R.drawable.person_icon,
            type = KeyboardType.Text
        ),
        InputInfo(
            inputLabel = R.string.responsible,
            icon = R.drawable.person_icon,
            type = KeyboardType.Text
        ),
        InputInfo(
            inputLabel = R.string.email,
            icon = R.drawable.email_icon,
            type = KeyboardType.Email
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

    val locationEstablishmentInputInfos = listOf(
        InputInfo(
            inputLabel = R.string.cnpj,
            icon = R.drawable.badge_icon,
            type = KeyboardType.Text
        ),
        InputInfo(
            inputLabel = R.string.cep,
            icon = R.drawable.location_icon,
            type = KeyboardType.Text
        ),
        InputInfo(
            inputLabel = R.string.address,
            icon = R.drawable.location_icon,
            type = KeyboardType.Text
        ),
        InputInfo(
            inputLabel = R.string.state,
            icon = R.drawable.location_icon,
            type = KeyboardType.Text
        ),
        InputInfo(
            inputLabel = R.string.number,
            icon = R.drawable.number_icon,
            type = KeyboardType.Number
        )
    )
    val profileEstablishmentInputInfos = listOf(
        InputInfo(
            inputLabel = R.string.fantasy_name,
            icon = R.drawable.person_icon,
            type = KeyboardType.Text
        ),
        InputInfo(
            inputLabel = R.string.phone,
            icon = R.drawable.baseline_phone_24,
            type = KeyboardType.Phone
        ),
        InputInfo(
            inputLabel = R.string.description,
            icon = R.drawable.stars,
            type = KeyboardType.Text
        ),
        InputInfo(
            inputLabel = R.string.name,
            icon = R.drawable.person_icon,
            type = KeyboardType.Text
        ),
    )
}


