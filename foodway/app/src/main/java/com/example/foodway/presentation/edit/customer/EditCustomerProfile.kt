package com.example.foodway.presentation.edit.customer

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
import com.example.foodway.domain.edit.customer.model.EditCustomerProfile
import com.example.foodway.domain.model.CustomerInputManager.profileCustomerInputInfos
import com.example.foodway.domain.model.UserType
import com.example.foodway.domain.profile.customer.model.ProfileCustomer
import com.example.foodway.presentation.MainScreenState
import com.example.foodway.presentation.components.ButtonGeneric
import com.example.foodway.presentation.components.InputGeneric
import com.example.foodway.presentation.edit.EditViewModel
import com.example.foodway.presentation.edit.UploadImage
import com.example.foodway.utils.PreferencesManager
import java.util.UUID

@Composable
fun EditCustomerProfile(
    vm: EditViewModel,
    onNavigateEditAccount: () -> Unit,
    onNavigateSuccessEdit: () -> Unit,
    sharedPreferences: PreferencesManager,
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
                type = UserType.CLIENT
            )
        }

        is MainScreenState.Error, null -> {
            val errorMessage = (state as MainScreenState.Error).message
            Log.d("Error", "Error state")
            ErrorView(message = errorMessage) {
                vm.getProfile(
                    idUser = UUID.fromString(sharedPreferences.getSavedData("id", "")),
                    type = UserType.CLIENT
                )
            }
        }

        is MainScreenState.Success<*> -> {
            val profile = (state as MainScreenState.Success<ProfileCustomer>).data

            var name by remember { mutableStateOf(profile.name) }
            var bio by remember { mutableStateOf(profile.bio) }
            var imageUri = rememberSaveable { mutableStateOf(profile.profilePhoto) }

            Column(
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier
                    .padding(10.dp)
                    .fillMaxWidth()
                    .fillMaxSize()
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween,
                    modifier = Modifier
                        .width(320.dp)
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
//                            vm.editImage(
//                                uri = imageUri.value,
//                                context = context,
//                            )
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
                            inputLabel = profileCustomerInputInfos[0].inputLabel,
                            icon = profileCustomerInputInfos[0].icon,
                            keyboardOptions = KeyboardOptions(
                                keyboardType = profileCustomerInputInfos[0].type
                            ),
                            visualTransformation = VisualTransformation.None,
                            labelState = name,
                            onValueChange = {
                                name = it
                            },
                        )

                        Spacer(modifier = Modifier.height(30.dp))

                        InputGeneric(
                            inputLabel = profileCustomerInputInfos[1].inputLabel,
                            icon = profileCustomerInputInfos[1].icon,
                            keyboardOptions = KeyboardOptions(
                                keyboardType = profileCustomerInputInfos[1].type
                            ),
                            visualTransformation = VisualTransformation.None,
                            labelState = bio,
                            onValueChange = {
                                bio = it
                            },
                        )

                        Spacer(modifier = Modifier.height(40.dp))

                        ButtonGeneric(
                            text = stringResource(id = R.string.save),
                            textSize = 18,
                            modifier = Modifier
                                .width(320.dp)
                                .height(43.dp),
                            isPrimary = true
                        ) {
                            vm.editProfile(
                                UUID.fromString(sharedPreferences.getSavedData("id", "")),
                                editCustomerProfile = EditCustomerProfile(
                                    name = name,
                                    photo = imageUri.value,
                                    bio = bio
                                ),
                                onNavigateSuccessEdit = { onNavigateSuccessEdit() }
                            )
                        }

                        Spacer(modifier = Modifier.height(20.dp))

                        ButtonGeneric(
                            text = stringResource(id = R.string.edit_account),
                            textSize = 18,
                            modifier = Modifier
                                .width(320.dp)
                                .height(43.dp),
                            isPrimary = false
                        ) {
                            onNavigateEditAccount()
                        }
                    }
                }
            }
        }
    }
}

//@Preview(showBackground = true)
//@Composable
//fun EditProfilePreview() {
//    EditCustomerProfile()
//}