package com.example.foodway.view.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.foodway.R

@Composable
fun CardUser() {
    Card(
        colors = CardDefaults.cardColors(
            containerColor = Color.Transparent
        ),
        modifier = Modifier
            .width(95.dp)
            .height(130.dp)
            .border(1.dp, colorResource(id = R.color.light_gray), RoundedCornerShape(10.dp))
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.SpaceAround,
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight()
                .padding(3.dp)
        ) {
            Text(
                text = "Mc Donalds",
                fontSize = 11.sp,
                fontWeight = FontWeight.SemiBold,
                color = colorResource(id = R.color.black)
            )
            Image(
                modifier = Modifier
                    .size(65.dp),
                painter = painterResource(id = R.drawable.imgmc),
                contentDescription = stringResource(id = R.string.estab_tab)
            )
            Row {
                RateUser(rate = 3.5)
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun CardUserPreview() {
    CardUser()
}