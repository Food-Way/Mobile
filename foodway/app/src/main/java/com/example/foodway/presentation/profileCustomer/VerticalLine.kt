package com.example.foodway.presentation.profileCustomer

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.foodway.R

@Composable
fun VerticalLine() {
    val color = colorResource(id = R.color.black)
    Canvas(modifier = Modifier.height(100.dp)) {
        val startX = size.width / 2
        val startY = 0f
        val endX = size.width / 2
        val endY = size.height

        drawLine(
            color = color,
            start = Offset(startX, startY),
            end = Offset(endX, endY),
            strokeWidth = 2.dp.toPx(),
            cap = StrokeCap.Round
        )
    }
}

@Preview(showBackground = true)
@Composable
fun VerticalLinePreview() {
    VerticalLine()
}