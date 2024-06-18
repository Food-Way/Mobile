package com.example.foodway.presentation.edit.establishment

import ErrorView
import LoadingBar
import android.util.Log
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
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
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.foodway.R
import com.example.foodway.domain.edit.establishment.model.EditEstablishmentProfile
import com.example.foodway.domain.edit.establishment.model.GetProfileEstablishmentEdit
import com.example.foodway.domain.model.ETypeUser
import com.example.foodway.domain.model.EstablishmentInputManager.profileEstablishmentInputInfos
import com.example.foodway.presentation.MainScreenState
import com.example.foodway.presentation.components.ButtonGeneric
import com.example.foodway.presentation.components.InputGeneric
import com.example.foodway.presentation.edit.EditViewModel
import com.example.foodway.presentation.edit.UploadImage
import com.example.foodway.presentation.navigation.AppDestination
import com.example.foodway.utils.Destination
import com.example.foodway.utils.PreferencesManager
import com.example.foodway.utils.ProfileId
import java.util.UUID

@Composable
fun EditEstablishmentProfile(
    vm: EditViewModel,
    sharedPreferences: PreferencesManager,
    onNavigateSuccessEdit: (Destination, ProfileId) -> Unit,
    onNavigateSuccessEditImage: (Destination) -> Unit,
    onLogout: () -> Unit,
    onNavigateEditAccount: () -> Unit
) {

    val state by vm.state.observeAsState()
    val context = LocalContext.current

    when (state) {
        is MainScreenState.Loading -> {
            Log.d("loading", "loading state")
            LoadingBar(
                loadingText = "Carregando informações..."
            )
            vm.getProfile(
                idUser = UUID.fromString(sharedPreferences.getSavedData("id", "")),
                type = ETypeUser.ESTABLISHMENT
            )
        }

        is MainScreenState.Error, null -> {
            val errorMessage = (state as MainScreenState.Error).message
            Log.d("Error", "Error state")
            ErrorView(message = errorMessage) {
                vm.getProfile(
                    idUser = UUID.fromString(sharedPreferences.getSavedData("id", "")),
                    type = ETypeUser.ESTABLISHMENT
                )
            }
        }

        is MainScreenState.Success<*> -> {
            val profile = (state as MainScreenState.Success<GetProfileEstablishmentEdit>).data
            var name by remember { mutableStateOf(profile.establishmentName) }
            var description by remember { mutableStateOf(profile.description) }
            var phone by remember { mutableStateOf(profile.phone) }
            var imageUri = rememberSaveable { mutableStateOf(profile.profilePhoto) }

            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center,
                modifier = Modifier
                    .padding(16.dp)
                    .fillMaxWidth()
                    .fillMaxSize()
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween,
                    modifier = Modifier
                        .width(310.dp)
                ) {
                    Column {
                        Text(
                            text = stringResource(id = R.string.edit_perfil_emoji),
                            color = colorResource(id = R.color.light_black),
                            fontWeight = FontWeight.Bold,
                        )

                        Text(
                            text = stringResource(id = R.string.adjust_necessary),
                            fontSize = 12.sp,
                        )
                    }

                    UploadImage(
                        imageUri = imageUri.value,
                        onChangeImage = { newImageUri ->
                            imageUri.value = newImageUri
                        },
                        onclick = {
                            vm.editImage(
                                uri = imageUri.value,
                                context = context,
                                sharedPreferences = sharedPreferences,
                                typeUser = ETypeUser.ESTABLISHMENT.name,
//                                onNavigateSuccessEditImage = onNavigateSuccessEditImage
                            )
                        },
                        size = 80.dp
                    )
                }

                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center
                ) {

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
                        
                        Spacer(modifier = Modifier.height(15.dp))
                        
                        InputGeneric(
                            inputLabel = profileEstablishmentInputInfos[0].inputLabel,
                            icon = profileEstablishmentInputInfos[0].icon,
                            keyboardOptions = KeyboardOptions(
                                keyboardType = profileEstablishmentInputInfos[0].type
                            ),
                            visualTransformation = VisualTransformation.None,
                            labelState = description,
                            onValueChange = {
                                description = it
                            },
                        )

                        Spacer(modifier = Modifier.height(15.dp))

                        InputGeneric(
                            inputLabel = profileEstablishmentInputInfos[1].inputLabel,
                            icon = profileEstablishmentInputInfos[1].icon,
                            keyboardOptions = KeyboardOptions(
                                keyboardType = profileEstablishmentInputInfos[1].type
                            ),
                            visualTransformation = VisualTransformation.None,
                            labelState = phone,
                            onValueChange = {
                                phone = it
                            },
                        )

                        Spacer(modifier = Modifier.height(20.dp))

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
                                    establishmentName = name,
                                    description = description,
                                    phone = phone,
                                    profilePhoto = imageUri.value ?: "",
                                ),
                                onNavigateSuccessEdit = {
                                    onNavigateSuccessEdit(
                                        AppDestination.ProfileEstablishment.route,
                                        UUID.fromString(sharedPreferences.getSavedData("id", ""))
                                            .toString(),
                                    )
                                },
                                uri = imageUri.value,
                                context = context,
                                typeUser = ETypeUser.ESTABLISHMENT.name,
                                sharedPreferences = sharedPreferences,
                                profilePhotoOld = profile.profilePhoto
                            )
                        }

                        Spacer(modifier = Modifier.height(20.dp))

                        ButtonGeneric(
                            text = stringResource(id = R.string.edit_account),
                            textSize = 18,
                            modifier = Modifier
                                .width(270.dp)
                                .height(43.dp),
                            isPrimary = false
                        ) {
                            onNavigateEditAccount()
                        }

                        Spacer(modifier = Modifier.height(20.dp))

                        ButtonGeneric(
                            text = stringResource(id = R.string.logout),
                            textSize = 18,
                            modifier = Modifier
                                .width(270.dp)
                                .height(43.dp),
                            isPrimary = false
                        ) {
                            onLogout()
                        }
                    }
                }
            }
        }
    }
}