package com.example.foodway.view.signUp.customer

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
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
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.foodway.R
import com.example.foodway.ui.theme.FoodwayTheme
import com.example.foodway.view.components.ButtonGeneric
import com.example.foodway.view.components.ScreenBorder
import com.example.foodway.viewModel.SignUpViewModel

@Composable
fun StepOneCustomer(
    onNavigate: () -> Unit = {},
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

//                Column {
//                    InputGeneric(
//                        inputLabel = personalCustomerInputInfos[0].inputLabel,
//                        icon = personalCustomerInputInfos[0].icon,
//                        keyboardOptions = KeyboardOptions(
//                            keyboardType = personalCustomerInputInfos[0].type
//                        ),
//                        labelState = name,
//                        onValueChange = {
//                            name = it
//                        },
//                    )
//
//                    InputGeneric(
//                        inputLabel = personalCustomerInputInfos[1].inputLabel,
//                        icon = personalCustomerInputInfos[1].icon,
//                        keyboardOptions = KeyboardOptions(
//                            keyboardType = personalCustomerInputInfos[1].type
//                        ),
//                        labelState = lastName,
//                        onValueChange = {
//                            lastName = it
//                        },
//                    )
//
//                    InputGeneric(
//                        inputLabel = personalCustomerInputInfos[2].inputLabel,
//                        icon = personalCustomerInputInfos[2].icon,
//                        keyboardOptions = KeyboardOptions(
//                            keyboardType = personalCustomerInputInfos[2].type
//                        ),
//                        labelState = cpf,
//                        onValueChange = {
//                            cpf = it
//                        },
//                    )
//
//                    InputGeneric(
//                        inputLabel = personalCustomerInputInfos[3].inputLabel,
//                        icon = personalCustomerInputInfos[3].icon,
//                        keyboardOptions = KeyboardOptions(
//                            keyboardType = personalCustomerInputInfos[3].type
//                        ),
//                        labelState = email,
//                        onValueChange = {
//                            email = it
//                        },
//                    )
//
//                    InputGeneric(
//                        inputLabel = personalCustomerInputInfos[4].inputLabel,
//                        icon = personalCustomerInputInfos[4].icon,
//                        keyboardOptions = KeyboardOptions(
//                            keyboardType = personalCustomerInputInfos[4].type
//                        ),
//                        labelState = password,
//                        onValueChange = {
//                            password = it
//                        },
//                    )
//
//                    InputGeneric(
//                        inputLabel = personalCustomerInputInfos[5].inputLabel,
//                        icon = personalCustomerInputInfos[5].icon,
//                        keyboardOptions = KeyboardOptions(
//                            keyboardType = personalCustomerInputInfos[2].type
//                        ),
//                        labelState = passwordConfirm,
//                        onValueChange = {
//                            passwordConfirm = it
//                        },
//                    )
//                }

//                LazyColumn {
//                    items(personalCustomerInputInfos.size) { item ->
//                        InputGeneric(
//                            inputLabel = personalCustomerInputInfos[item].inputLabel,
//                            icon = personalCustomerInputInfos[item].icon,
//                            keyboardOptions = KeyboardOptions(
//                                keyboardType = personalCustomerInputInfos[item].type
//                            ),
//                            labelState = states[item],
//                            onValueChange = {
//                                states[item] = it
//                            }
//                        )
//                    }
//                }

                ButtonGeneric(
                    text = stringResource(id = R.string.next),
                    modifier = Modifier
                        .width(250.dp)
                        .height(45.dp),
                    isPrimary = false,
                    onClick = {
                        onNavigate()
//                        savePersonalInfo(
//                            name,
//                            lastName,
//                            cpf,
//                            email,
//                            password,
//                        )
                    }
                )
            }
        }
    }
}

//@Preview(showBackground = true)
//@Composable
//fun StepOneActivityPreview() {
//    FoodwayTheme {
//        Surface(modifier = Modifier.fillMaxSize()) {
//            StepOneCustomer()
//        }
//    }
//}