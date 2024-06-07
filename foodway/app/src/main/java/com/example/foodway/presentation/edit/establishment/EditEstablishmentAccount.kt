package com.example.foodway.presentation.edit.establishment

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.foodway.R
import com.example.foodway.presentation.components.ButtonGeneric
import com.example.foodway.presentation.components.NoBorderScreen
import com.example.foodway.presentation.ui.theme.FoodwayTheme

@Composable
fun EditEstablishmentAccount() {

    FoodwayTheme {
        NoBorderScreen {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Column(
                    horizontalAlignment = Alignment.Start
                ) {
                    Row(verticalAlignment = Alignment.CenterVertically) {

                        Text(
                            fontWeight = FontWeight.Bold,
                            fontSize = 16.sp,
                            textAlign = TextAlign.Left,
                            text = stringResource(id = R.string.edit_account)
                        )
                        Image(
                            painter = painterResource(id = R.drawable.edit_icon),
                            contentDescription = stringResource(id = R.string.image_profile_desc),
                            modifier = Modifier
                                .size(24.dp)
                                .clip(CircleShape)
                                .padding(start = 8.dp),
                            contentScale = ContentScale.Fit
                        )
                    }
<<<<<<< Updated upstream
                    Text(
                        fontSize = 16.sp,
                        text = stringResource(id = R.string.adjust)
                    )
=======

                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .fillMaxHeight()
                            .padding(20.dp, 21.dp),
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.SpaceAround
                    ) {

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
                            },
                        )
                        InputGeneric(
                            inputLabel = personalEstablishmentInputInfos[4].inputLabel,
                            icon = personalEstablishmentInputInfos[4].icon,
                            keyboardOptions = KeyboardOptions(
                                keyboardType = personalEstablishmentInputInfos[4].type
                            ),
                            visualTransformation = PasswordVisualTransformation(),
                            labelState = confPassword,
                            onValueChange = {
                                confPassword = it
                            },
                        )

                        Spacer(modifier = Modifier.height(30.dp))

                        ButtonGeneric(
                            text = stringResource(id = R.string.save_button),
                            textSize = 18,
                            modifier = Modifier
                                .width(250.dp)
                                .height(45.dp),
                            isPrimary = true
                        ) {
                            vm.editAccount(
                                UUID.fromString(sharedPreferences.getSavedData("id", "")),
                                editEstablishmentAccount = EditEstablishmentAccount(
                                    fantasyName = fantasyName,
                                    responsible = responsible,
                                    email = email,
                                    password = password,
                                ),
                                onNavigateSuccess = { onNavigateSuccessEdit() }
                            )
                        }
                    }
>>>>>>> Stashed changes
                }

                Image(
                    painter = painterResource(id = R.drawable.goku),
                    contentDescription = stringResource(id = R.string.image_profile_desc),
                    modifier = Modifier
                        .size(70.dp)
                        .clip(CircleShape)
                        .padding(0.dp)
                )
            }

            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight()
                    .padding(20.dp, 21.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.SpaceAround
            ) {
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
                    text = stringResource(id = R.string.save_button),
                    modifier = Modifier
                        .width(250.dp)
                        .height(45.dp),
                    isPrimary = true
                ) {}
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun EditAccountEstablishmentPreview() {
    EditEstablishmentAccount()
}