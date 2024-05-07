package com.example.foodway.view.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.foodway.R

@Composable
fun RateUser(rate: Double) {
    Row(
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = rate.toString().replace(".",","),
            color = colorResource(id = R.color.black),
            fontSize = 14.sp
        )
        Spacer(
            modifier = Modifier
                .width(4.dp)
        )
        Image(
            painter = painterResource(id = R.drawable.star_filled),
            contentDescription = "Estrela de avaliação",
            modifier = Modifier.size(20.dp)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun RateUserPreview() {
    RateUser(rate = 3.5)
}