package com.example.foodway.view.signUp.establishment


import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.foodway.R
import com.example.foodway.ui.theme.FoodwayTheme
import com.example.foodway.view.components.ButtonGeneric
import com.example.foodway.view.components.Input
import com.example.foodway.view.components.ScreenBorder

@Composable
fun StepOneActivity(navController: NavController) {
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
                    text = stringResource(id = R.string.info_establishments)
                )
                Input(
                    inputLabel = stringResource(id = R.string.fantasy_name),
                    icon = R.drawable.person_icon
                )
                Input(
                    inputLabel = stringResource(id = R.string.responsible),
                    icon = R.drawable.person_icon
                )
                Input(
                    inputLabel = stringResource(id = R.string.email),
                    icon = R.drawable.email_icon
                )
                Input(
                    inputLabel = stringResource(id = R.string.password),
                    icon = R.drawable.lock_icon
                )
                Input(
                    inputLabel = stringResource(id = R.string.conf_password),
                    icon = R.drawable.lock_icon
                )
                ButtonGeneric(
                    text = stringResource(id = R.string.next),
                    width = 250.dp,
                    height = 45.dp,
                    isPrimary = false
                ) {
                    navController.navigate("StepTwo")
                }
            }
        }
    }
}
//
//@Preview(showBackground = true)
//@Composable
//fun StepOneActivityPreview() {
//    StepOneActivity()
//}