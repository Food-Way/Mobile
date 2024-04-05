package com.example.foodway.view.signUp.establishment

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
import com.example.foodway.view.components.ScreenBorder
import com.example.foodway.view.signUp.CategoryGrid

@Composable
fun StepThreeActivity(navController: NavController) {
    FoodwayTheme {
        ScreenBorder {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight()
                    .padding(20.dp, 21.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
            ) {
                Text(
                    fontWeight = FontWeight.Bold,
                    fontSize = 18.sp,
                    textAlign = TextAlign.Center,
                    text = "Seleção de Categorias"
                )
                CategoryGrid(
                    categories = listOf(
                        "Categoria 1",
                        "Categoria 2",
                        "Categoria 3",
                        "Categoria 4",
                        "Categoria 5",
                        "Categoria 6",
                        "Categoria 6",
                        "Categoria 6",
                    )
                )
                ButtonGeneric(
                    text = stringResource(id = R.string.next),
                    width = 250.dp,
                    height = 45.dp,
                    isPrimary = false
                ) {
                    navController.navigate("StepFour")
                }
            }
        }
    }
}

//@Preview(showBackground = true)
//@Composable
//fun StepThreeActivityPreview() {
//    StepThreeActivity()
//}
