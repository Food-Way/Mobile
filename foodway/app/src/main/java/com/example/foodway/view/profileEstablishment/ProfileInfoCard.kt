package com.example.foodway.view.profileEstablishment

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.width
import androidx.compose.material3.OutlinedCard
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.foodway.view.components.RateUser

@Composable
fun ProfileInfoCard() {
    OutlinedCard(
        modifier = Modifier
            .width(240.dp)
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(
                text = "Mc' Donalds",
                fontWeight = FontWeight.Bold,
                fontSize = 16.sp
            )
            Text(
                text = "Culinária Havaiana",
                fontWeight = FontWeight.Normal,
                fontSize = 10.sp
            )
            RateUser(rate = 5.0)
            Text(
                text = "Ótimo lugar para ter novas experiências com amigos e parentes. Venha conferir nossas delícias",
            )
            Row (
                horizontalArrangement = Arrangement.Start
            ) {
                CulinaryCard()
            }

            Row() {

            }

        }


    }
}

@Preview(showBackground = true)
@Composable
fun ProfileInfoCardPreview() {
    ProfileInfoCard()
}