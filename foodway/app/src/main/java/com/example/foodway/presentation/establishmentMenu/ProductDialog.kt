package com.example.foodway.presentation.establishmentMenu

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.foodway.presentation.components.ButtonGeneric
import com.example.foodway.presentation.components.CoilImage

@Composable
fun ProductDialog(
    modifier: Modifier,
    name: String,
    photo: String,
    description: String,
    price: Double,
    onDismissRequest: () -> Unit
) {
    Column (
        modifier = Modifier.padding(8.dp)
    ) {
        CoilImage(
            photo = photo,
            description = description,
            modifier = modifier
        )

        Spacer(modifier = Modifier.height(24.dp))

        Text(
            text = name,
            textAlign = TextAlign.Center,
            fontWeight = FontWeight.Bold,
            fontSize = 16.sp
        )

        Text(
            text = description,
            textAlign = TextAlign.Center,
            fontWeight = FontWeight.Bold,
            fontSize = 16.sp
        )

        Spacer(modifier = Modifier.height(48.dp))

        Text(
            text = "R$$price",
            textAlign = TextAlign.Center,
            fontWeight = FontWeight.Bold,
            fontSize = 16.sp
        )

        Spacer(modifier = Modifier.height(15.dp))

        ButtonGeneric(
            text = "Sair",
            textSize = 18,
            modifier = Modifier
                .width(250.dp)
                .height(50.dp)
                .align(Alignment.CenterHorizontally),
            isPrimary = false,
            onClick = { onDismissRequest() }
        )

    }
}