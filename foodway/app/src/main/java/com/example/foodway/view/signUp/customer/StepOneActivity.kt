package com.example.foodway.view.signUp.customer

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.foodway.R
import com.example.foodway.model.Input
import com.example.foodway.ui.theme.FoodwayTheme
import com.example.foodway.view.components.ButtonGeneric
import com.example.foodway.view.components.InputGeneric
import com.example.foodway.view.components.ScreenBorder

class StepOneActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            FoodwayTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    StepOneCustomerActivity()
                }
            }
        }
    }
}

@Composable
fun StepOneCustomerActivity(
    onNavigate: () -> Unit = {}
) {

    val inputList = listOf(
        Input(
            inputLabel = stringResource(id = R.string.fantasy_name),
            icon = R.drawable.person_icon,
            type = KeyboardType.Text
        ),
        Input(
            inputLabel = stringResource(id = R.string.responsible),
            icon = R.drawable.person_icon,
            type = KeyboardType.Text
        ),
        Input(
            inputLabel = stringResource(id = R.string.email),
            icon = R.drawable.person_icon,
            type = KeyboardType.Email
        ),
        Input(
            inputLabel = stringResource(id = R.string.password),
            icon = R.drawable.lock_icon,
            type = KeyboardType.Password
        ),
        Input(
            inputLabel = stringResource(id = R.string.conf_password),
            icon = R.drawable.lock_icon,
            type = KeyboardType.Password
        ),
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
                    items(inputList.size) { item ->
                        InputGeneric(
                            inputLabel = inputList[item].inputLabel,
                            icon = inputList[item].icon
                        )
                    }
                }

                ButtonGeneric(
                    text = stringResource(id = R.string.next),
                    width = 250.dp,
                    height = 45.dp,
                    isPrimary = false,
                    onClick = { onNavigate() }
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun StepOneActivityPreview() {
    FoodwayTheme {
        Surface(modifier = Modifier.fillMaxSize()) {
            StepOneCustomerActivity()

        }
    }
}