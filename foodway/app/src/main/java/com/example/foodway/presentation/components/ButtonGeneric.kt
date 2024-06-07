package com.example.foodway.presentation.components

import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.example.foodway.presentation.ui.theme.PrimaryButton
import com.example.foodway.presentation.ui.theme.SecondaryButton

@Composable
fun ButtonGeneric(
    modifier: Modifier,
    text: String,
    textSize: Int,
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
        modifier = modifier
    ) {
        Text(
            text = text,
            color = textColor,
            fontSize = textSize.sp,
            fontWeight = FontWeight.Bold
        )
    }
}

@Preview(showBackground = true)
@Composable
fun ButtonGenericTruePreview() {
    ButtonGeneric(
        modifier = Modifier
            .width(150.dp)
            .height(50.dp),
        text = "Teste true",
        textSize = 10,
        isPrimary = true
    ) {}
}

@Preview(showBackground = true)
@Composable
fun ButtonGenericFalsePreview() {
    ButtonGeneric(
        modifier = Modifier
            .width(150.dp)
            .height(50.dp),
        text = "Teste false",
        textSize = 10,
        isPrimary = false
    ) {}
}