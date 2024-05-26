package com.example.foodway.presentation.signUp.establishment

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
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
import com.example.foodway.presentation.components.ButtonGeneric
import com.example.foodway.presentation.components.ScreenBorder
import com.example.foodway.presentation.signUp.SignUpViewModel
import com.example.foodway.presentation.ui.theme.FoodwayTheme

@Composable
fun StepOneEstablishment(
    vm: SignUpViewModel,
    modifier: Modifier,
    onStepComplete : () -> Unit = {},
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

//                LazyColumn {
//                    items(personalEstablishmentInputInfos.size) { item ->
//                        InputGeneric(
//                            inputLabel = personalEstablishmentInputInfos[item].inputLabel,
//                            icon = personalEstablishmentInputInfos[item].icon,
//                            keyboardOptions = KeyboardOptions(
//                                keyboardType = personalEstablishmentInputInfos[item].type
//                            )
//                        )
//                    }
//                }

                ButtonGeneric(
                    text = stringResource(id = R.string.next),
                    modifier = Modifier
                        .width(250.dp)
                        .height(45.dp),
                    isPrimary = false,
                    onClick = { onStepComplete() }
                )
            }
        }
    }
}