package com.example.foodway.presentation.edit.establishment

import ErrorView
import LoadingBar
import android.util.Log
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.foodway.R
import com.example.foodway.domain.edit.establishment.model.GetProfileEstablishmentEdit
import com.example.foodway.domain.model.EstablishmentInputManager.personalEstablishmentInputInfos
import com.example.foodway.domain.model.UserType
import com.example.foodway.presentation.MainScreenState
import com.example.foodway.presentation.components.ButtonGeneric
import com.example.foodway.presentation.components.InputGeneric
import com.example.foodway.presentation.components.NoBorderScreen
import com.example.foodway.presentation.components.ProfileImage
import com.example.foodway.presentation.edit.EditViewModel
import com.example.foodway.presentation.ui.theme.FoodwayTheme
import com.example.foodway.utils.PreferencesManager
import java.util.UUID

@Composable
fun EditEstablishmentAccount(
    vm: EditViewModel,
    sharedPreferences: PreferencesManager,
    onNavigateSuccessEdit: () -> Unit,
    onNavigateEditProfile: () -> Unit
) {

    val state by vm.state.observeAsState()

    when (state) {
        is MainScreenState.Loading -> {
            Log.d("loading", "loading state")
            LoadingBar(
                loadingText = "Carregando informações..."
            )
            vm.getProfile(
                idUser = UUID.fromString(sharedPreferences.getSavedData("id", "")),
                type = UserType.ESTABLISHMENT
            )
        }

        is MainScreenState.Error, null -> {
            val errorMessage = (state as MainScreenState.Error).message
            Log.d("Error", "Error state")
            ErrorView(message = errorMessage) {
                vm.getProfile(
                    idUser = UUID.fromString(sharedPreferences.getSavedData("id", "")),
                    type = UserType.ESTABLISHMENT
                )
            }
        }

        is MainScreenState.Success<*> -> {
            val profile = (state as MainScreenState.Success<GetProfileEstablishmentEdit>).data
            var name by remember { mutableStateOf(profile.name) }
            var establishmentName by remember { mutableStateOf(profile.establishmentName) }
            var email by remember { mutableStateOf(profile.email) }
            var password by remember { mutableStateOf("") }
            var confPassword by remember { mutableStateOf("") }

            FoodwayTheme {
                NoBorderScreen {
                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Row(
                            horizontalArrangement = Arrangement.SpaceBetween,
                            verticalAlignment = Alignment.CenterVertically,
                            modifier = Modifier
                                .width(310.dp)
                        ) {
                            Column(
                                horizontalAlignment = Alignment.Start
                            ) {
                                Row(verticalAlignment = Alignment.CenterVertically) {

                                    Text(
                                        fontWeight = FontWeight.Bold,
                                        textAlign = TextAlign.Left,
                                        text = stringResource(id = R.string.edit_account)
                                    )
                                }
                                Text(
                                    fontSize = 12.sp,
                                    text = stringResource(id = R.string.adjust)
                                )
                            }

                            Card(
                                shape = CircleShape,
                                border = BorderStroke(2.dp, colorResource(id = R.color.light_gray)),
                                modifier = Modifier
                                    .size(80.dp)
                            ) {
                                ProfileImage(photo = profile.profilePhoto, size = 80.dp)
                            }
                        }

                        Column(
                            modifier = Modifier
                                .fillMaxWidth()
                                .fillMaxHeight(),
                            horizontalAlignment = Alignment.CenterHorizontally,
                            verticalArrangement = Arrangement.SpaceAround
                        ) {
                            Spacer(modifier = Modifier.height(20.dp))

                            InputGeneric(
                                inputLabel = personalEstablishmentInputInfos[0].inputLabel,
                                icon = personalEstablishmentInputInfos[0].icon,
                                keyboardOptions = KeyboardOptions(
                                    keyboardType = personalEstablishmentInputInfos[0].type
                                ),
                                visualTransformation = VisualTransformation.None,
                                labelState = name,
                                onValueChange = {
                                    name = it
                                },
                            )

                            Spacer(modifier = Modifier.height(10.dp))

                            InputGeneric(
                                inputLabel = personalEstablishmentInputInfos[1].inputLabel,
                                icon = personalEstablishmentInputInfos[1].icon,
                                keyboardOptions = KeyboardOptions(
                                    keyboardType = personalEstablishmentInputInfos[1].type
                                ),
                                visualTransformation = VisualTransformation.None,
                                labelState = establishmentName,
                                onValueChange = {
                                    establishmentName = it
                                },
                            )

                            Spacer(modifier = Modifier.height(10.dp))

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

                            Spacer(modifier = Modifier.height(10.dp))

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

                            Spacer(modifier = Modifier.height(10.dp))

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
//                        InputGeneric(
//                            inputLabel = personalEstablishmentInputInfos[4].inputLabel,
//                            icon = personalEstablishmentInputInfos[4].icon,
//                            keyboardOptions = KeyboardOptions(
//                                keyboardType = personalEstablishmentInputInfos[4].type
//                            ),
//                            visualTransformation = PasswordVisualTransformation(),
//                            labelState = confPassword,
//                            onValueChange = {
//                                confPassword = it
//                            },
//                        )

                            Spacer(modifier = Modifier.height(20.dp))

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
//                                editEstablishmentAccount = EditEstablishmentAccount(
////                                    fantasyName = fantasyName,
////                                    responsible = responsible,
////                                    email = email,
////                                    password = password,
//                                ),
                                    onNavigateSuccess = { onNavigateSuccessEdit() },
                                    sharedPreferences = sharedPreferences
                                )
                            }
                        }
                    }
                }
            }
        }
    }
}