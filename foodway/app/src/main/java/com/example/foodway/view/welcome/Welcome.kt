package com.example.foodway.view.welcome

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
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
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.foodway.R
import com.example.foodway.ui.theme.FoodwayTheme
import com.example.foodway.ui.theme.PrimaryButton

@Composable
fun Welcome() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 50.dp, start = 50.dp),
            horizontalAlignment = Alignment.Start
        ) {
            Box(
                modifier = Modifier
                    .size(150.dp)
                    .background(Color.Transparent)
                    .border(width = 1.dp, Color.Black, shape = RoundedCornerShape(12.dp))
            ) {
                Image(
                    painter = painterResource(id = R.drawable.foodway_logo),
                    contentDescription = null,
                    modifier = Modifier
                        .padding(10.dp)
                )
            }
        }
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 150.dp, end = 40.dp),
            horizontalAlignment = Alignment.End
        ) {
            Box(
                modifier = Modifier
                    .size(150.dp)
                    .background(Color.Transparent)
                    .border(width = 1.dp, Color.Black, shape = RoundedCornerShape(12.dp))
            ) {
                Image(
                    painter = painterResource(id = R.drawable.support_outline),
                    contentDescription = null,
                    modifier = Modifier
                        .padding(top = 10.dp)
                        .fillMaxSize()
                )
            }
        }
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.Transparent)
                .align(Alignment.Center) // Alinha o Box no centro
        ) {
            Image(
                painter = painterResource(id = R.drawable.cake_slice),
                contentDescription = null,
                modifier = Modifier
                    .padding(start = 50.dp, top = 30.dp)
                    .size(300.dp)
            )
        }
        Column(
            modifier = Modifier
                .align(Alignment.Center)
                .padding(top = 100.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                text = stringResource(id = R.string.welcome_title),
                style = TextStyle(
                    color = Color.Black,
                    fontSize = 25.sp,
                    fontWeight = FontWeight.Bold
                ),
                modifier = Modifier
                    .padding(bottom = 55.dp)
            )
            Spacer(modifier = Modifier.size(16.dp))
            Text(
                text = stringResource(id = R.string.welcome_text),
                style = TextStyle(
                    textAlign = TextAlign.Center,
                    fontSize = 16.sp
                ),
                modifier = Modifier
                    .padding(bottom = 45.dp)
            )
        }
        Button(
            onClick = { /*TODO*/ },
            shape = RoundedCornerShape(10.dp),
            modifier = Modifier
                .width(170.dp)
                .height(170.dp)
                .align(Alignment.BottomCenter)
                .padding(bottom = 120.dp),
            colors = PrimaryButton()
        )
        {
            Text(
                stringResource(id = R.string.start),
                style = TextStyle(fontSize = 16.sp)
            )
        }
    }
}



@Preview(showBackground = true)
@Composable
fun AppPreview() {
    FoodwayTheme {
        Surface(modifier = Modifier.fillMaxSize()) {
            Welcome()
        }
    }
}