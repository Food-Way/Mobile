package com.example.foodway

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
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
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.foodway.ui.theme.ButtonColor
import com.example.foodway.ui.theme.FoodwayTheme



class WelcomeActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            FoodwayTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    AppWelcome()
                }
            }
        }
    }
}

@Composable
fun AppWelcome(){
   Box(modifier = Modifier
       .fillMaxSize()
       .background(Color.White)
   ){
       Column(
           modifier = Modifier
               .fillMaxWidth()
               .offset(y = (50).dp)
               .offset(x = (50).dp),
           horizontalAlignment = Alignment.Start

           )
       {
           Box(modifier = Modifier
               .size(150.dp)
               .background(Color.Transparent)
               .border(width = 1.dp, Color.Black, shape = RoundedCornerShape(12.dp))
           ){
               Image(painter = painterResource(id = R.drawable.foodway_logo),
                   contentDescription = null,
                   modifier = Modifier

                       .offset(x = (10).dp)
                       .offset(y = (10).dp))
           }


       }
       Column(
           modifier = Modifier
               .fillMaxWidth()
               .offset(y = (150).dp)
               .offset(x = (-40).dp),
           horizontalAlignment = Alignment.End

       )
       {
           Box(modifier = Modifier
               .size(150.dp)
               .background(Color.Transparent)
               .border(width = 1.dp, Color.Black, shape = RoundedCornerShape(12.dp))
           ){
               Image(painter = painterResource(id = R.drawable.support_outline),
                   contentDescription = null,
                   modifier = Modifier

                       .offset(y = (10).dp)
                       .fillMaxSize())
           }

           Box(modifier = Modifier
               .size(300.dp)
               .background(Color.Transparent)){

               Image(painter = painterResource(id = R.drawable.cake_slice),
                   contentDescription = null,
                   modifier = Modifier

                       .offset(x = (-20).dp)
                       .offset(y = (-280).dp)
                       .fillMaxSize())

           }

       }


       Column (modifier = Modifier
           .align(Alignment.Center)
           .offset(y = (100).dp),
           horizontalAlignment = Alignment.CenterHorizontally,
           verticalArrangement = Arrangement.Center){
           Text(text = "Bem-vindo ao Foodway!",
               style = TextStyle(color = Color.Black,
                   fontSize = 25.sp,
                   fontWeight = FontWeight.Bold),
                   modifier = Modifier
                       .offset(y = (-55).dp)
           )

           Spacer(modifier = Modifier.size(16.dp))

           Text(text = "Sua jornada gastronômica começa aqui.\n " +
                   "Explore restaurantes, descubra ofertas exclusivas\n" +
                   " e compartilhe suas experiências.",
               style = TextStyle(textAlign = TextAlign.Center,
                   fontSize = 15.sp ),
               modifier = Modifier
                   .offset(y = (-45).dp)
           )
       }
       Button(onClick = { /*TODO*/ },

           shape = RoundedCornerShape(10.dp),
           modifier = Modifier
               .width(170.dp)
               .height(45.dp)
               .align(Alignment.Center)
               .offset(y = (200).dp)
               .background(Color.White),
           colors = ButtonColor()
           )
       {
           Text("Começar",
               style = TextStyle(fontSize = 16.sp)
           )
       }
   }
}


@Preview(showBackground = true)
@Composable
fun AppPreview() {
    FoodwayTheme {
        Surface (modifier = Modifier.fillMaxSize()) {
            AppWelcome()

        }

    }
}