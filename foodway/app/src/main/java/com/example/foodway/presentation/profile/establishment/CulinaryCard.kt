package com.example.foodway.presentation.profile.establishment

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.unit.dp
import com.example.foodway.R

@Composable
fun CulinaryCard(
    culinary: String
) {
    Box(
        modifier = Modifier
            .background(
                colorResource(id = R.color.black),
            )
            .width(50.dp)
            .height(20.dp)
            .border(1.dp, Color.Black, shape = RoundedCornerShape(5.dp)),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = culinary,
            color = colorResource(id = R.color.white)
        )
    }
}