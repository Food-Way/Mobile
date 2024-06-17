package com.example.foodway.presentation.establishmentMenu

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.foodway.R
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
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween,
        modifier = Modifier
            .fillMaxWidth()
    ) {
        Text(
            text = "Produto",
            fontWeight = FontWeight.Bold,
            fontSize = 20.sp
        )
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier
                .width(35.dp)
                .height(35.dp)
                .clip(RoundedCornerShape(20.dp))
                .background(colorResource(id = R.color.light_gray))
        ) {
            Icon(
                imageVector = Icons.Filled.Close,
                contentDescription = "",
                tint = colorResource(android.R.color.darker_gray),
                modifier = Modifier
                    .width(30.dp)
                    .height(30.dp)
                    .clickable { onDismissRequest() }
            )
        }
    }
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
            fontWeight = FontWeight.Normal,
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
    }
}