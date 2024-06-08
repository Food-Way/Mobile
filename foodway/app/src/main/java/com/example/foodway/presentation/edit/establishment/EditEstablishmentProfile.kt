package com.example.foodway.presentation.edit.establishment

import ErrorView
import LoadingBar
import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
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
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.foodway.R
import com.example.foodway.domain.edit.establishment.model.EditEstablishmentProfile
import com.example.foodway.domain.edit.establishment.model.GetProfileEstablishmentEdit
import com.example.foodway.domain.model.EstablishmentInputManager.profileEstablishmentInputInfos
import com.example.foodway.domain.model.UserType
import com.example.foodway.presentation.MainScreenState
import com.example.foodway.presentation.components.ButtonGeneric
import com.example.foodway.presentation.components.InputGeneric
import com.example.foodway.presentation.edit.EditViewModel
import com.example.foodway.utils.PreferencesManager
import java.util.UUID

@Composable
fun EditEstablishmentProfile(
    vm: EditViewModel,
    sharedPreferences: PreferencesManager,
    onNavigateSuccessEdit: () -> Unit,
    onNavigateEditAccount: () -> Unit
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
            var name by remember { mutableStateOf(profile.establishmentName) }
//            var description by remember { mutableStateOf(profile.description) }

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
//                        InputGeneric(
//                            inputLabel = profileEstablishmentInputInfos[1].inputLabel,
//                            icon = profileEstablishmentInputInfos[1].icon,
//                            keyboardOptions = KeyboardOptions(
//                                keyboardType = profileEstablishmentInputInfos[1].type
//                            ),
//                            visualTransformation = VisualTransformation.None,
//                            labelState = description,
//                            onValueChange = {
//                                description = it
//                            },
//                        )

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
//                                    description = description
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
        }
    }
}