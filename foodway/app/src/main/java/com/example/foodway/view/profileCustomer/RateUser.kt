package com.example.foodway.view.profileCustomer

import androidx.compose.foundation.layout.Row
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun RateUser() {
    Row {
        Text(
            text = "3,5"
        )

    }
}

@Preview(showBackground = true)
@Composable
fun RateUserPreview() {
    RateUser()
}