package com.example.foodway.view.register

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.foodway.R
import com.example.foodway.view.components.ButtonGeneric

@Composable
fun StepOneRegisterUser(){
    Column(
        verticalArrangement = Arrangement.Center,
        modifier = Modifier
            .padding(25.dp)
            .fillMaxWidth()
            .fillMaxSize()
    ) {

        Spacer(modifier = Modifier.height(30.dp))

//        LazyColumn(
//            horizontalAlignment = Alignment.CenterHorizontally,
//            verticalArrangement = Arrangement.Center
//        ) {
//            items(CustomerInputManager.personalCustomerInputInfos.size) { item ->
//                InputGeneric(
//                    inputLabel = CustomerInputManager.personalCustomerInputInfos[item].inputLabel,
//                    icon = CustomerInputManager.personalCustomerInputInfos[item].icon,
//                    keyboardOptions = KeyboardOptions(
//                        keyboardType = CustomerInputManager.personalCustomerInputInfos[item].type
//                    ),
//                )
//
//                Spacer(modifier = Modifier.height(10.dp))
//            }
//        }

        Spacer(modifier = Modifier.height(30.dp))

        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
            modifier = Modifier.fillMaxWidth()
        ) {
            ButtonGeneric(
                text = stringResource(id = R.string.next),
                modifier = Modifier
                    .width(300.dp)
                    .height(43.dp),
                isPrimary = false
            ) {}
        }

    }
}

@Preview(showBackground = true)
@Composable
fun StepOneRegisterUserPreview() {
    StepOneRegisterUser()
}