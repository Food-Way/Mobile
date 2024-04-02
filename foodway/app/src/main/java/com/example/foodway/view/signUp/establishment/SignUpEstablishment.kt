package com.example.foodway.view.signUp.establishment


import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.example.foodway.R
import com.example.foodway.ui.theme.FoodwayTheme

@Composable
fun SignUpEstablishment() {
    FoodwayTheme {
        ScreenBorder {
            Column() {
                Input(inputLabel = "Senha", icon = R.drawable.lock_icon)
                Input(inputLabel = "Email", icon = R.drawable.email_icon)
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun SignUpEstablishmentPreview() {
    SignUpEstablishment()
}