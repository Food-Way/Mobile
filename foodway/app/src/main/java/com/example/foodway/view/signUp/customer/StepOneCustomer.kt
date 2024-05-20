package com.example.foodway.view.signUp.customer

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
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
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.foodway.R
import com.example.foodway.model.CustomerInputManager
import com.example.foodway.ui.theme.FoodwayTheme
import com.example.foodway.view.components.ButtonGeneric
import com.example.foodway.view.components.InputGeneric
import com.example.foodway.view.components.ScreenBorder
import com.example.foodway.viewModel.SignUpViewModel

@Composable
fun StepOne(
    modifier: Modifier,
    onStepComplete: () -> Unit,
    vm: SignUpViewModel
) {
    var name by remember {
        mutableStateOf("")
    }

    var lastName by remember {
        mutableStateOf("")
    }

    var cpf by remember {
        mutableStateOf("")
    }

    var email by remember {
        mutableStateOf("")
    }

    var password by remember {
        mutableStateOf("")
    }

    var passwordConfirm by remember {
        mutableStateOf("")
    }

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

                Column {
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
                            vm.updateName(name)
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
                            vm.updateLastName(lastName)
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
                            vm.updateCPF(cpf)
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
                            vm.updateEmail(email)
                        },
                    )

                    InputGeneric(
                        inputLabel = CustomerInputManager.personalCustomerInputInfos[4].inputLabel,
                        icon = CustomerInputManager.personalCustomerInputInfos[4].icon,
                        keyboardOptions = KeyboardOptions(
                            keyboardType = CustomerInputManager.personalCustomerInputInfos[4].type
                        ),
                        visualTransformation = PasswordVisualTransformation(),
                        labelState = password,
                        onValueChange = {
                            password = it
                            vm.updatePassword(password)
                        },
                    )

                    InputGeneric(
                        inputLabel = CustomerInputManager.personalCustomerInputInfos[5].inputLabel,
                        icon = CustomerInputManager.personalCustomerInputInfos[5].icon,
                        keyboardOptions = KeyboardOptions(
                            keyboardType = CustomerInputManager.personalCustomerInputInfos[2].type
                        ),
                        visualTransformation = PasswordVisualTransformation(),
                        labelState = passwordConfirm,
                        onValueChange = {
                            passwordConfirm = it
                        },
                    )
                }

                ButtonGeneric(
                    text = stringResource(id = R.string.next),
                    modifier = Modifier
                        .width(250.dp)
                        .height(45.dp),
                    isPrimary = false,
                    onClick = {
                        onStepComplete(

                        )
                    }
                )
            }
        }
    }
}