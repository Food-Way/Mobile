package com.example.foodway.presentation.profile.establishment

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.foodway.R

@Composable
fun CulinaryCard(
    culinary: String
) {
    Box(
        modifier = Modifier
            .background(
                colorResource(id = R.color.black),
                RoundedCornerShape(5.dp)
            )
            .width(65.dp)
            .height(23.dp),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = culinary,
            fontSize = 12.sp,
            color = colorResource(id = R.color.white)
        )
    }
}