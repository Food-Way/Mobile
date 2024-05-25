package com.example.foodway.presentation.profileCustomer

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.example.foodway.R

@Composable
fun Welcome(name: String, modifier: Modifier = Modifier) {
    Column {
        Text(
            text = stringResource(R.string.hi, name),
            fontWeight = FontWeight.Bold,
        )
        Text(
            text = stringResource(id = R.string.your_profile),
            fontSize = 12.sp
        )
    }
}

@Preview(showBackground = true)
@Composable
fun WelcomePreview() {
    Welcome(name = "Samuel")
}