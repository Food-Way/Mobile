package com.example.foodway.presentation.signUp.establishment

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
import com.example.foodway.domain.model.EstablishmentInputManager.personalEstablishmentInputInfos
import com.example.foodway.presentation.components.ButtonGeneric
import com.example.foodway.presentation.components.InputGeneric
import com.example.foodway.presentation.components.ScreenBorder
import com.example.foodway.presentation.signUp.SignUpViewModel
import com.example.foodway.presentation.ui.theme.FoodwayTheme

@Composable
fun StepOneEstablishment(
    vm: SignUpViewModel,
    modifier: Modifier,
    onStepComplete : () -> Unit = {},
    onGoBack: () -> Unit
) {

    var fantasyName by remember {
        mutableStateOf("")
    }

    var responsible by remember {
        mutableStateOf("")
    }

    var email by remember {
        mutableStateOf("")
    }

    var password by remember {
        mutableStateOf("")
    }

    var confirmPassword by remember {
        mutableStateOf("")
    }

    FoodwayTheme {
        ScreenBorder {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(600.dp)
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

                InputGeneric(
                    inputLabel = personalEstablishmentInputInfos[0].inputLabel,
                    icon = personalEstablishmentInputInfos[0].icon,
                    keyboardOptions = KeyboardOptions(
                        keyboardType = personalEstablishmentInputInfos[0].type
                    ),
                    visualTransformation = VisualTransformation.None,
                    labelState = fantasyName,
                    onValueChange = {
                        fantasyName = it
                        vm.updateFantasyName(fantasyName)
                    },
                )

                InputGeneric(
                    inputLabel = personalEstablishmentInputInfos[1].inputLabel,
                    icon = personalEstablishmentInputInfos[1].icon,
                    keyboardOptions = KeyboardOptions(
                        keyboardType = personalEstablishmentInputInfos[1].type
                    ),
                    visualTransformation = VisualTransformation.None,
                    labelState = responsible,
                    onValueChange = {
                        responsible = it
                        vm.updateResponsible(responsible)
                    },
                )

                InputGeneric(
                    inputLabel = personalEstablishmentInputInfos[2].inputLabel,
                    icon = personalEstablishmentInputInfos[2].icon,
                    keyboardOptions = KeyboardOptions(
                        keyboardType = personalEstablishmentInputInfos[2].type
                    ),
                    visualTransformation = VisualTransformation.None,
                    labelState = email,
                    onValueChange = {
                        email = it
                        vm.updateEmail(email)
                    },
                )

                InputGeneric(
                    inputLabel = personalEstablishmentInputInfos[3].inputLabel,
                    icon = personalEstablishmentInputInfos[3].icon,
                    keyboardOptions = KeyboardOptions(
                        keyboardType = personalEstablishmentInputInfos[3].type
                    ),
                    visualTransformation = PasswordVisualTransformation(),
                    labelState = password,
                    onValueChange = {
                        password = it
                        vm.updatePassword(password)
                    },
                )

                InputGeneric(
                    inputLabel = personalEstablishmentInputInfos[4].inputLabel,
                    icon = personalEstablishmentInputInfos[4].icon,
                    keyboardOptions = KeyboardOptions(
                        keyboardType = personalEstablishmentInputInfos[4].type
                    ),
                    visualTransformation = PasswordVisualTransformation(),
                    labelState = confirmPassword,
                    onValueChange = {
                        confirmPassword = it
                    },
                )

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