package com.example.foodway.presentation.edit.establishment

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.foodway.R
import com.example.foodway.presentation.components.ButtonGeneric

@Composable
fun EditEstablishmentProfile() {
    Column(
        verticalArrangement = Arrangement.Center,
        modifier = Modifier
            .padding(16.dp)
            .fillMaxWidth()
            .fillMaxSize()

    ) {
        Column {
            Text(
                text = stringResource(id = R.string.edit_perfil_emoji),
                fontWeight = FontWeight.ExtraBold,
                fontSize = 18.sp,
            )

            Text(
                text = stringResource(id = R.string.adjust_necessary),
                fontSize = 15.sp,
            )
        }

        Spacer(modifier = Modifier.height(30.dp))

        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {

            Image(
                painter = painterResource(id = R.drawable.foodway_logo),
                contentDescription = stringResource(id = R.string.logo),
                modifier = Modifier
                    .width(95.dp)
                    .height(98.dp)
                    .align(Alignment.CenterHorizontally)
            )

            Spacer(modifier = Modifier.height(10.dp))

            ButtonGeneric(
                text = stringResource(id = R.string.save),
                modifier = Modifier
                    .width(270.dp)
                    .height(43.dp),
                isPrimary = true
            ) {}

            Spacer(modifier = Modifier.height(30.dp))

//            LazyColumn{
//                items(profileEstablishmentInputInfos.size) { item ->
//                    InputGeneric(
//                        inputLabel = profileEstablishmentInputInfos[item].inputLabel,
//                        icon = profileEstablishmentInputInfos[item].icon,
//                        keyboardOptions = KeyboardOptions(
//                            keyboardType = profileEstablishmentInputInfos[item].type
//                        )
//                    )
//                }
//            }

            Spacer(modifier = Modifier.height(30.dp))

            ButtonGeneric(
                text = stringResource(id = R.string.save),
                modifier = Modifier
                    .width(270.dp)
                    .height(43.dp),
                isPrimary = true
            ) {}

<<<<<<< Updated upstream
            Spacer(modifier = Modifier.height(20.dp))

            ButtonGeneric(
                text = stringResource(id = R.string.save),
                modifier = Modifier
                    .width(270.dp)
                    .height(43.dp),
                isPrimary = true
            ) {}
=======
                    ButtonGeneric(
                        text = stringResource(id = R.string.save),
                        textSize = 18,
                        modifier = Modifier
                            .width(270.dp)
                            .height(43.dp),
                        isPrimary = true
                    ) {}

                    Spacer(modifier = Modifier.height(30.dp))

                    Column(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(16.dp),
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.Center
                    ) {
                        InputGeneric(
                            inputLabel = profileEstablishmentInputInfos[0].inputLabel,
                            icon = profileEstablishmentInputInfos[0].icon,
                            keyboardOptions = KeyboardOptions(
                                keyboardType = profileEstablishmentInputInfos[0].type
                            ),
                            visualTransformation = VisualTransformation.None,
                            labelState = name,
                            onValueChange = {
                                name = it
                            },
                        )
                        InputGeneric(
                            inputLabel = profileEstablishmentInputInfos[1].inputLabel,
                            icon = profileEstablishmentInputInfos[1].icon,
                            keyboardOptions = KeyboardOptions(
                                keyboardType = profileEstablishmentInputInfos[1].type
                            ),
                            visualTransformation = VisualTransformation.None,
                            labelState = description,
                            onValueChange = {
                                description = it
                            },
                        )

                        Spacer(modifier = Modifier.height(30.dp))

                        ButtonGeneric(
                            text = stringResource(id = R.string.save),
                            textSize = 18,
                            modifier = Modifier
                                .width(270.dp)
                                .height(43.dp),
                            isPrimary = true
                        ) {
                            vm.editProfile(
                                UUID.fromString(sharedPreferences.getSavedData("id", "")),
                                editEstablishmentProfile = EditEstablishmentProfile(
                                    name = name,
                                    photo = "",
                                    description = description
                                ),
                                onNavigateSuccessEdit = { onNavigateSuccessEdit() }
                            )
                        }

                        Spacer(modifier = Modifier.height(20.dp))

                        ButtonGeneric(
                            text = stringResource(id = R.string.edit_account),
                            textSize = 18,
                            modifier = Modifier
                                .width(270.dp)
                                .height(43.dp),
                            isPrimary = true
                        ) {
                            onNavigateEditAccount()
                        }
                    }
                }
            }
>>>>>>> Stashed changes
        }
    }
}

@Preview(showBackground = true)
@Composable
fun EditProfilePreview() {
    EditEstablishmentProfile()
}