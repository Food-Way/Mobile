package com.example.foodway.view.signUp.customer

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.foodway.R
import com.example.foodway.ui.theme.FoodwayTheme
import com.example.foodway.ui.theme.SecondaryButton

class SignUpActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            FoodwayTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    StepOneActivity()
                }
            }
        }
    }
}

@Composable
fun StepOneActivity() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
    ) {
        Box(
            modifier = Modifier
                .border(width = 0.5.dp, Color.Gray, shape = RoundedCornerShape(30.dp))
                .align(Alignment.Center)
                .size(width = 300.dp, height = 700.dp)
        )
        {
            Column(
                modifier = Modifier
                    .align(Alignment.Center)
            ) {
                Text(
                    text = stringResource(id = R.string.info_user),
                    style = TextStyle(
                        color = Color.Black,
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Bold
                    ),
                    modifier = Modifier
                        .offset(y = (-320).dp)
                )
            }
            Button(
                onClick = { /*TODO*/ },
                shape = RoundedCornerShape(10.dp),
                modifier = Modifier
                    .width(250.dp)
                    .height(45.dp)
                    .align(Alignment.Center)
                    .offset(y = (300).dp),
                colors = SecondaryButton()
            ) {
                Text(
                    stringResource(id = R.string.next),
                    style = TextStyle(fontSize = 16.sp)
                )
            }
        }
        Box(
            modifier = Modifier
                .size(width = 50.dp, height = 70.dp)
                .offset(y = (150).dp)
                .offset(x = (20).dp)
        ) {
            Button(
                onClick = { /*TODO*/ },
                shape = RoundedCornerShape(12.dp),
                modifier = Modifier
                    .fillMaxSize(),
                colors = SecondaryButton()

            ) {}
            Image(
                painter = painterResource(id = R.drawable.back),
                contentDescription = null,
                modifier = Modifier
                    .size(width = 40.dp, height = 70.dp)
                    .offset(y = (-10).dp)
            )
            Text(
                text = stringResource(id = R.string.previous),
                style = TextStyle(Color.White),
                modifier = Modifier
                    .align(Alignment.Center)
                    .offset(y = (20).dp)
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun StepOneActivityPreview() {
    FoodwayTheme {
        Surface(modifier = Modifier.fillMaxSize()) {
            StepOneActivity()
        }
    }
}