package com.example.foodway.view.profileCustomer

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun WelcomeProfile() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(125.dp),
        horizontalArrangement = Arrangement.SpaceAround,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Welcome(name = "Samuel")
        Profile()
    }
}

@Preview(showBackground = true)
@Composable
fun WelcomeProfilePreview() {
    WelcomeProfile()
}