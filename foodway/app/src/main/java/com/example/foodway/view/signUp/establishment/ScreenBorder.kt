package com.example.foodway.view.signUp.establishment

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun ScreenBorder(content: @Composable () -> Unit) {
    Surface(
        Modifier
            .padding(30.dp)
            .fillMaxSize()
    ) {
        Box(
            modifier = Modifier
                .border(
                    width = 0.5.dp,
                    color = Color.Gray,
                    shape = RoundedCornerShape(30.dp)
                )
        ) {
            content()
        }
    }
}

//@Composable
//@Preview(showBackground = true)
//fun ScreenBorderPreview() {
//    ScreenBorder()
//}