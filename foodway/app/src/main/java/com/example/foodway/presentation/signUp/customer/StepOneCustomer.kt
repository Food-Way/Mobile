package com.example.foodway.presentation.signUp.customer

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Icon
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.foodway.R
import com.example.foodway.domain.model.CustomerInputManager
import com.example.foodway.presentation.components.ButtonGeneric
import com.example.foodway.presentation.components.InputGeneric
import com.example.foodway.presentation.components.ScreenBorder
import com.example.foodway.presentation.ui.theme.FoodwayTheme
import com.example.foodway.presentation.signUp.SignUpViewModel

@Composable
fun StepOneCustomer(
    modifier: Modifier,
    onStepComplete: () -> Unit,
    onGoBack: () -> Unit,
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

                Column(
                    verticalArrangement = Arrangement.SpaceBetween,
                    modifier = Modifier
                        .height(100.dp)
                ) {
                    ButtonGeneric(
                        text = stringResource(id = R.string.next),
                        textSize = 18,
                        modifier = Modifier
                            .width(250.dp)
                            .height(45.dp),
                        isPrimary = true,
                        onClick = {
                            onStepComplete()
                        }
                    )
                    ButtonGeneric(
                        text = stringResource(id = R.string.previous),
                        textSize = 18,
                        modifier = Modifier
                            .width(250.dp)
                            .height(45.dp),
                        isPrimary = false,
                        onClick = {
                            onGoBack()
                        }
                    )
                }
            }
        }
    }
}
