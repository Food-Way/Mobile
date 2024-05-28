package com.example.foodway.presentation.edit.customer

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.foodway.R
import com.example.foodway.domain.model.CustomerInputManager
import com.example.foodway.presentation.components.ButtonGeneric
import com.example.foodway.presentation.components.InputGeneric

@Composable
fun EditCustomerAccount() {

    var name by remember { mutableStateOf("") }
    var lastName by remember { mutableStateOf("") }
    var cpf by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var confPassword by remember { mutableStateOf("") }

    Column(
        verticalArrangement = Arrangement.Center,
        modifier = Modifier
            .padding(25.dp)
            .fillMaxWidth()
            .fillMaxSize()
    ) {
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxWidth()

        ) {
            Column {
                Text(
                    text = stringResource(id = R.string.edit_account),
                    fontWeight = FontWeight.ExtraBold,
                    fontSize = 18.sp,
                )

                Text(
                    text = stringResource(id = R.string.adjust_necessary),
                    fontSize = 15.sp,
                )
            }

            Image(
                painter = painterResource(id = R.drawable.foodway_logo),
                contentDescription = stringResource(id = R.string.logo),
                modifier = Modifier
                    .width(95.dp)
                    .height(98.dp)
            )
        }

        Spacer(modifier = Modifier.height(30.dp))

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {

            InputGeneric(
                inputLabel = CustomerInputManager.personalCustomerInputInfos[0].inputLabel,
                icon = CustomerInputManager.personalCustomerInputInfos[0].icon,
                keyboardOptions = KeyboardOptions(
                    keyboardType = CustomerInputManager.personalCustomerInputInfos[0].type
                ),
                visualTransformation = VisualTransformation.None,
                labelState = name,
                onValueChange = {
                    name = it
                },
            )

            InputGeneric(
                inputLabel = CustomerInputManager.personalCustomerInputInfos[1].inputLabel,
                icon = CustomerInputManager.personalCustomerInputInfos[1].icon,
                keyboardOptions = KeyboardOptions(
                    keyboardType = CustomerInputManager.personalCustomerInputInfos[1].type
                ),
                visualTransformation = VisualTransformation.None,
                labelState = lastName,
                onValueChange = {
                    lastName = it
                },
            )

            InputGeneric(
                inputLabel = CustomerInputManager.personalCustomerInputInfos[2].inputLabel,
                icon = CustomerInputManager.personalCustomerInputInfos[2].icon,
                keyboardOptions = KeyboardOptions(
                    keyboardType = CustomerInputManager.personalCustomerInputInfos[2].type
                ),
                visualTransformation = VisualTransformation.None,
                labelState = cpf,
                onValueChange = {
                    cpf = it
                },
            )

            InputGeneric(
                inputLabel = CustomerInputManager.personalCustomerInputInfos[3].inputLabel,
                icon = CustomerInputManager.personalCustomerInputInfos[3].icon,
                keyboardOptions = KeyboardOptions(
                    keyboardType = CustomerInputManager.personalCustomerInputInfos[3].type
                ),
                visualTransformation = VisualTransformation.None,
                labelState = email,
                onValueChange = {
                    email = it
                },
            )

            InputGeneric(
                inputLabel = CustomerInputManager.personalCustomerInputInfos[4].inputLabel,
                icon = CustomerInputManager.personalCustomerInputInfos[4].icon,
                keyboardOptions = KeyboardOptions(
                    keyboardType = CustomerInputManager.personalCustomerInputInfos[4].type
                ),
                visualTransformation = VisualTransformation.None,
                labelState = password,
                onValueChange = {
                    password = it
                },
            )

            InputGeneric(
                inputLabel = CustomerInputManager.personalCustomerInputInfos[5].inputLabel,
                icon = CustomerInputManager.personalCustomerInputInfos[5].icon,
                keyboardOptions = KeyboardOptions(
                    keyboardType = CustomerInputManager.personalCustomerInputInfos[5].type
                ),
                visualTransformation = VisualTransformation.None,
                labelState = confPassword,
                onValueChange = {
                    confPassword = it
                },
            )
        }

        Spacer(modifier = Modifier.height(30.dp))

        ButtonGeneric(
            text = stringResource(id = R.string.save),
            modifier = Modifier
                .width(270.dp)
                .height(43.dp),
            isPrimary = true
        ) {}

        Spacer(modifier = Modifier.height(20.dp))
    }
}

@Preview(showBackground = true)
@Composable
fun EditAccountPreview() {
    EditCustomerAccount()
}
