package com.example.foodway.view.components

import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.text.font.FontWeight
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

@Preview(showBackground = true)
@Composable
fun ButtonGenericTruePreview() {
    ButtonGeneric(
        text = "Teste true",
        width = 150.dp,
        height = 50.dp,
        isPrimary = true
    ) {}
}
@Preview(showBackground = true)
@Composable
fun ButtonGenericFalsePreview() {
    ButtonGeneric(
        text = "Teste false",
        width = 150.dp,
        height = 50.dp,
        isPrimary = false
    ) {}
}