package com.example.foodway.view.signUp.customer

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.foodway.R
import com.example.foodway.model.CustomerInputManager
import com.example.foodway.ui.theme.FoodwayTheme
import com.example.foodway.view.components.ButtonGeneric
import com.example.foodway.view.components.InputGeneric
import com.example.foodway.view.components.ScreenBorder

@Composable
fun StepOneCustomer(
    onNavigate: () -> Unit = {}
) {

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
                    items(CustomerInputManager.personalCustomerInputInfos.size) { item ->
                        InputGeneric(
                            inputLabel = CustomerInputManager.personalCustomerInputInfos[item].inputLabel,
                            icon = CustomerInputManager.personalCustomerInputInfos[item].icon,
                            keyboardOptions = KeyboardOptions(
                                keyboardType = CustomerInputManager.personalCustomerInputInfos[item].type
                            )
                        )
                    }
                }

                ButtonGeneric(
                    text = stringResource(id = R.string.next),
                    modifier = Modifier
                        .width(250.dp)
                        .height(45.dp),
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
            StepOneCustomer()
        }
    }
}