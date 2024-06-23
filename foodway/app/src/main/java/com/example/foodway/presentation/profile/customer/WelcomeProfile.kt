package com.example.foodway.presentation.profile.customer

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun WelcomeProfile(
    name: String,
    photo: String,
    level: Int,
    xp: Double
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(125.dp),
        horizontalArrangement = Arrangement.SpaceAround,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Welcome(
            name = name
        )
        Profile(
            photo = photo,
            level = level,
            xp = xp
        )
    }
}

//@Preview(showBackground = true)
//@Composable
//fun WelcomeProfilePreview() {
//    WelcomeProfile(
//        name = "Samuel"
//    )
//}