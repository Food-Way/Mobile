package com.example.foodway.view.signUp.establishment

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.foodway.R
import com.example.foodway.model.Input
import com.example.foodway.ui.theme.FoodwayTheme
import com.example.foodway.view.components.ButtonGeneric
import com.example.foodway.view.components.InputGeneric
import com.example.foodway.view.components.ScreenBorder

class StepTwoActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            StepTwoEstablishmentActivity()
        }
    }
}

@Composable
fun StepTwoEstablishmentActivity(
    onNavigate: () -> Unit = {}
) {
    val inputList = listOf(
        Input(
            inputLabel = stringResource(id = R.string.cnpj),
            icon = R.drawable.badge_icon
        ),
        Input(
            inputLabel = stringResource(id = R.string.cep),
            icon = R.drawable.location_icon
        ),
        Input(
            inputLabel = stringResource(id = R.string.address),
            icon = R.drawable.location_icon
        ),
        Input(
            inputLabel = stringResource(id = R.string.state),
            icon = R.drawable.location_icon
        ),
        Input(
            inputLabel = stringResource(id = R.string.number),
            icon = R.drawable.number_icon
        )
    )
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

                LazyColumn {
                    items(inputList.size) { index ->
                        InputGeneric(
                            inputLabel = inputList[index].inputLabel,
                            icon = inputList[index].icon
                        )
                    }
                }

                ButtonGeneric(
                    text = stringResource(id = R.string.next),
                    width = 250.dp,
                    height = 45.dp,
                    isPrimary = false,
                    onClick = {onNavigate()}
                )
            }
        }
    }
}