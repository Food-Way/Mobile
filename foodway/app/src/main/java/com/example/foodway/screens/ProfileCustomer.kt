package com.example.foodway.screens

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.foodway.R
import com.example.foodway.components.NavBarComponent
import com.example.foodway.ui.theme.FoodwayTheme

class ProfileCustomer : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ProfileCustomerScreen()
        }
    }
}

@Composable
fun ProfileCustomerScreen() {
    FoodwayTheme {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
            Column(
                verticalArrangement = Arrangement.SpaceBetween
            ) {
                WelcomeProfile()
                Row (
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.Center
                ) {
                    CardInfoUser()
                }
                NavBarComponent()
            }
        }
    }
}

@Composable
fun Welcome(name: String, modifier: Modifier = Modifier) {
    Column {
        Text(
            text = "${stringResource(id = R.string.hi)}, $name 👋",
            fontWeight = FontWeight.Bold,

            )
        Text(
            text = "Esse é seu perfil",
            fontSize = 12.sp
        )
    }
}

@Composable
fun Profile() {
    var levelNum = 999;
    Row (
        modifier = Modifier.width(145.dp),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Column (
            modifier = Modifier.height(75.dp),
            verticalArrangement = Arrangement.Center
        ){
            Text(
                text = "${stringResource(id = R.string.level)} $levelNum"
            )
            Row(
                modifier = Modifier.width(57.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceAround
            ) {
                Text(
                    text = "XP",
                    fontSize = 12.sp,
                    fontWeight = FontWeight.Bold
                )
                LinearProgressIndicator(
                    progress = 0.5f,
                    modifier = Modifier
                        .width(36.dp)
                        .height(6.dp),
                    color = Color.Green,
                    trackColor = Color.LightGray,
                    strokeCap = StrokeCap.Round,
                )
            }
        }

        Image(
            painter = painterResource(id = R.drawable.goku),
            contentDescription = "Image profile",
            modifier = Modifier
                .size(75.dp)
                .clip(CircleShape)
                .padding(0.dp),
            contentScale = ContentScale.Fit
        )
    }
}

@Composable
fun WelcomeProfile() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(125.dp),
        horizontalArrangement = Arrangement.SpaceAround,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Welcome(name = "Samuel")
        Profile()
    }
}

@Composable
fun RateUser() {
    Row {
        Text(
            text = "3,5"
        )

    }
}

@Composable
fun VerticalLine() {
    Canvas(modifier = Modifier.height(70.dp)) {
        val startX = size.width / 2
        val startY = 0f
        val endX = size.width / 2
        val endY = size.height

        drawLine(
            color = Color.Black,
            start = Offset(startX, startY),
            end = Offset(endX, endY),
            strokeWidth = 2 .dp.toPx(),
            cap = StrokeCap.Round
        )
    }
}

@Composable
fun CardInfoUser() {
    Row(
        modifier = Modifier
            .border(1.dp, Color.LightGray, RoundedCornerShape(10.dp))
            .width(300.dp)
            .padding(10.dp),
        horizontalArrangement = Arrangement.SpaceAround
    ) {
        Column(
            modifier = Modifier
                .width(120.dp)
                .height(80.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(text = "Comentários")
            Row(
                modifier = Modifier.width(60.dp),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(text = "100")
                Image(
                    painter = painterResource(id = R.drawable.comment),
                    contentDescription = "Comment",
                    modifier = Modifier
                        .size(25.dp)
                        .padding(0.dp),
                    contentScale = ContentScale.Fit
                )
            }
        }
        Column(
            modifier = Modifier
        ) {
            VerticalLine()
        }
        Column(
            modifier = Modifier
                .width(120.dp)
                .height(80.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(text = "Upvotes")
            Row(
                modifier = Modifier.width(60.dp),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(text = "100")
                Image(
                    painter = painterResource(id = R.drawable.upvote),
                    contentDescription = "Upvotes",
                    modifier = Modifier
                        .size(25.dp)
                        .padding(0.dp),
                    contentScale = ContentScale.Fit
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    ProfileCustomerScreen()
}