package com.example.foodway

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.foodway.ui.theme.ButtonSignUp
import com.example.foodway.ui.theme.FoodwayTheme

class SignUpActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            FoodwayTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    SignUpApp()
                }
            }
        }
    }
}

@Composable
fun SignUpApp(){
    Box(modifier = Modifier
        .fillMaxSize()
        .background(Color.White)
    ){
        Box(
            modifier = Modifier
                .border(width = 0.5.dp, Color.Gray, shape = RoundedCornerShape(30.dp))
                .align(Alignment.Center)
                .size(width = 300.dp, height = 700.dp))
        {

Button(onClick = { /*TODO*/ },
    shape = RoundedCornerShape(10.dp),
    modifier = Modifier
        .width(250.dp)
        .height(45.dp)
        .align(Alignment.Center)
        .offset(y = (300).dp),
    colors = ButtonSignUp()

    ) {
    Text("Próximo",
        style = TextStyle(fontSize = 16.sp))
}
        }
    }
}

@Preview(showBackground = true)
@Composable
fun SignUpAppPreview() {
    FoodwayTheme {
        Surface (modifier = Modifier.fillMaxSize()) {

 SignUpApp()

        }

    }
}