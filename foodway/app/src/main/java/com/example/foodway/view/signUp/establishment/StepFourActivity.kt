package com.example.foodway.view.signUp.establishment

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.foodway.R
import com.example.foodway.ui.theme.FoodwayTheme
import com.example.foodway.view.components.ButtonGeneric
import com.example.foodway.view.components.ScreenBorder

@Composable
fun StepFourActivity(navController: NavController) {
    FoodwayTheme {
        ScreenBorder {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight()
                    .padding(20.dp, 21.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.SpaceAround
            ) {
                Text(
                    fontWeight = FontWeight.Bold,
                    fontSize = 18.sp,
                    textAlign = TextAlign.Center,
                    text = stringResource(id = R.string.conclusion_title)
                )

                //Steps

                Text(
                    fontWeight = FontWeight.Bold,
                    text = stringResource(id = R.string.sign_up_sucess_title)
                )
                Text(
                    textAlign = TextAlign.Justify,
                    text = stringResource(id = R.string.congrat_text),
                    modifier = Modifier.fillMaxWidth()
                )
                Image(
                    painter = painterResource(id = R.drawable.sign_up_finish_image),
                    contentDescription = stringResource(id = R.string.conclusion_image_desc),
                    modifier = Modifier
                        .width(240.dp)
                        .height(160.dp)
                )
                ButtonGeneric(
                    text = stringResource(id = R.string.conclusion_button),
                    width = 250.dp,
                    height = 45.dp,
                    isPrimary = true
                ) {}
            }
        }
    }
}

//@Preview(showBackground = true)
//@Composable
//fun StepFourActivityPreview() {
//    StepFourActivity()
//}
