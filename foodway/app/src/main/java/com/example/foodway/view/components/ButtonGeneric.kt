package com.example.foodway.view.components

import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.sp
import com.example.foodway.ui.theme.PrimaryButton
import com.example.foodway.ui.theme.SecondaryButton

@Composable
fun ButtonGeneric(
    text: String,
    width: Dp,
    height: Dp,
    isPrimary: Boolean,
    textColor: Color = Color.White,
    onClick: () -> Unit
) {
    val colors = if (isPrimary) {
        PrimaryButton()
    } else {
        SecondaryButton()
    }

    Button(
        onClick = onClick,
        colors = colors,
        modifier = Modifier
            .width(width)
            .height(height)
    ) {
        Text(
            text = text,
            color = textColor,
            fontSize = 18.sp,
            fontWeight = FontWeight.Bold
        )
    }
}