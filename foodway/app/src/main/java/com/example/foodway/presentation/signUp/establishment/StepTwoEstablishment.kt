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
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.foodway.R
import com.example.foodway.domain.model.EstablishmentInputManager.locationEstablishmentInputInfos
import com.example.foodway.presentation.components.ButtonGeneric
import com.example.foodway.presentation.components.InputGeneric
import com.example.foodway.presentation.components.ScreenBorder
import com.example.foodway.presentation.signUp.SignUpViewModel
import com.example.foodway.presentation.ui.theme.FoodwayTheme

@Composable
fun StepTwoEstablishment(
    modifier: Modifier,
    vm: SignUpViewModel,
    onStepComplete : () -> Unit = {},
    onGoBack: () -> Unit = {}
) {
    var cnpj by remember { mutableStateOf("") }
    var cep by remember { mutableStateOf("") }
    var address by remember { mutableStateOf("") }
    var state by remember { mutableStateOf("") }
    var number by remember { mutableStateOf("") }

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

                InputGeneric(
                    inputLabel = locationEstablishmentInputInfos[0].inputLabel,
                    icon = locationEstablishmentInputInfos[0].icon,
                    keyboardOptions = KeyboardOptions(
                        keyboardType = locationEstablishmentInputInfos[0].type
                    ),
                    visualTransformation = VisualTransformation.None,
                    labelState = cnpj,
                    onValueChange = {
                        cnpj = it
                        vm.updateCNPJ(cnpj)
                    },
                )

                InputGeneric(
                    inputLabel = locationEstablishmentInputInfos[1].inputLabel,
                    icon = locationEstablishmentInputInfos[1].icon,
                    keyboardOptions = KeyboardOptions(
                        keyboardType = locationEstablishmentInputInfos[1].type
                    ),
                    visualTransformation = VisualTransformation.None,
                    labelState = cep,
                    onValueChange = {
                        cep = it
                        vm.updateCEP(cep)
                    },
                )

//                InputGeneric(
//                    inputLabel = locationEstablishmentInputInfos[2].inputLabel,
//                    icon = locationEstablishmentInputInfos[2].icon,
//                    keyboardOptions = KeyboardOptions(
//                        keyboardType = locationEstablishmentInputInfos[2].type
//                    ),
//                    visualTransformation = VisualTransformation.None,
//                    labelState = address,
//                    onValueChange = {
//                        address = it
//                        vm.updateAddress(address)
//                    },
//                )
//
//                InputGeneric(
//                    inputLabel = locationEstablishmentInputInfos[3].inputLabel,
//                    icon = locationEstablishmentInputInfos[3].icon,
//                    keyboardOptions = KeyboardOptions(
//                        keyboardType = locationEstablishmentInputInfos[3].type
//                    ),
//                    visualTransformation = VisualTransformation.None,
//                    labelState = state,
//                    onValueChange = {
//                        state = it
//                        vm.updateState(state)
//                    },
//                )

                InputGeneric(
                    inputLabel = locationEstablishmentInputInfos[4].inputLabel,
                    icon = locationEstablishmentInputInfos[4].icon,
                    keyboardOptions = KeyboardOptions(
                        keyboardType = locationEstablishmentInputInfos[4].type
                    ),
                    visualTransformation = VisualTransformation.None,
                    labelState = number,
                    onValueChange = {
                        number = it
                        vm.updateNumber(number)
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