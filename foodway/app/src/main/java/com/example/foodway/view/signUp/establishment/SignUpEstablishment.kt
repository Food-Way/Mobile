package com.example.foodway.view.signUp.establishment

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.foodway.ui.theme.FoodwayTheme

class SignUpEstablishment : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SignUpEstablishment()
        }
    }
}

@Composable
fun SignUpEstablishment(modifier: Modifier) {
    FoodwayTheme {

    }
}

@Preview(showBackground = true)
@Composable
fun SignUpEstablishmentPreview() {
    SignUpEstablishment()
}