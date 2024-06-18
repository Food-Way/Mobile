package com.example.foodway.presentation.edit.customer

import ErrorView
import LoadingBar
import android.util.Log
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
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
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.foodway.R
import com.example.foodway.domain.edit.customer.model.EditCustomerAccount
import com.example.foodway.domain.model.CustomerInputManager
import com.example.foodway.domain.model.ETypeUser
import com.example.foodway.domain.profile.customer.model.ProfileCustomer
import com.example.foodway.presentation.MainScreenState
import com.example.foodway.presentation.components.ButtonGeneric
import com.example.foodway.presentation.components.InputGeneric
import com.example.foodway.presentation.components.ProfileImage
import com.example.foodway.presentation.edit.EditViewModel
import com.example.foodway.utils.PreferencesManager
import com.example.foodway.utils.ProfileId
import java.util.UUID

@Composable
fun EditCustomerAccount(
    vm: EditViewModel,
    sharedPreferences: PreferencesManager,
    onNavigateSuccessEdit: (ProfileId) -> Unit,
    onNavigateConfiguration: () -> Unit,
) {

    val state by vm.state.observeAsState()
    val id = UUID.fromString(sharedPreferences.getSavedData("id", ""))

    when (state) {
        is MainScreenState.Loading -> {
            Log.d("loading", "loading state")
            LoadingBar(
                loadingText = "Carregando informações..."
            )
            vm.getProfile(
                idUser = UUID.fromString(sharedPreferences.getSavedData("id", "")),
                type = ETypeUser.CLIENT
            )
        }

        is MainScreenState.Error, null -> {
            val errorMessage = (state as MainScreenState.Error).message
            Log.d("Error", "Error state")
            ErrorView(message = errorMessage) {
                vm.getProfile(
                    idUser = UUID.fromString(sharedPreferences.getSavedData("id", "")),
                    type = ETypeUser.CLIENT
                )
            }
        }

        is MainScreenState.Success<*> -> {
            val profile = (state as MainScreenState.Success<ProfileCustomer>).data
            Log.d("Success", "Success state")

            var cpf by remember { mutableStateOf(profile.cpf ?: "000.000.000-00") }
            var email by remember { mutableStateOf(profile.email) }
            var newEmail by remember { mutableStateOf("") }
            var password by remember { mutableStateOf("") }
            var newPassword by remember { mutableStateOf("") }

            Column(
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier
                    .padding(25.dp)
                    .fillMaxWidth()
                    .fillMaxSize()
            ) {
                Row(
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier
                        .width(300.dp)

                ) {
                    Column {
                        Text(
                            text = stringResource(id = R.string.edit_account),
                            fontWeight = FontWeight.Bold,
                        )

                        Text(
                            text = stringResource(id = R.string.adjust_necessary),
                            fontSize = 12.sp,
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
                        .fillMaxSize()
                        .padding(16.dp),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center
                ) {

                    InputGeneric(
                        inputLabel = CustomerInputManager.personalCustomerInputInfos[2].inputLabel,
                        icon = CustomerInputManager.personalCustomerInputInfos[2].icon,
                        keyboardOptions = KeyboardOptions(
                            keyboardType = CustomerInputManager.personalCustomerInputInfos[2].type
                        ),
                        visualTransformation = VisualTransformation.None,
                        labelState = cpf,
                        onValueChange = {
                            cpf = it
                        },
                    )

                    Spacer(modifier = Modifier.height(10.dp))

                    InputGeneric(
                        inputLabel = R.string.newEmail,
                        icon = CustomerInputManager.personalCustomerInputInfos[3].icon,
                        keyboardOptions = KeyboardOptions(
                            keyboardType = CustomerInputManager.personalCustomerInputInfos[3].type
                        ),
                        visualTransformation = VisualTransformation.None,
                        labelState = newEmail,
                        onValueChange = {
                            newEmail = it
                        },
                    )

                    Spacer(modifier = Modifier.height(10.dp))

                    InputGeneric(
                        inputLabel = R.string.oldPass,
                        icon = CustomerInputManager.personalCustomerInputInfos[4].icon,
                        keyboardOptions = KeyboardOptions(
                            keyboardType = CustomerInputManager.personalCustomerInputInfos[4].type
                        ),
                        visualTransformation = PasswordVisualTransformation(),
                        labelState = password,
                        onValueChange = {
                            password = it
                        },
                    )

                    Spacer(modifier = Modifier.height(10.dp))

                    InputGeneric(
                        inputLabel = R.string.newPass,
                        icon = CustomerInputManager.personalCustomerInputInfos[5].icon,
                        keyboardOptions = KeyboardOptions(
                            keyboardType = CustomerInputManager.personalCustomerInputInfos[5].type
                        ),
                        visualTransformation = PasswordVisualTransformation(),
                        labelState = newPassword,
                        onValueChange = {
                            newPassword = it
                        },
                    )

                    Spacer(modifier = Modifier.height(23.dp))

                    ButtonGeneric(
                        text = stringResource(id = R.string.save),
                        textSize = 18,
                        modifier = Modifier
                            .width(270.dp)
                            .height(43.dp),
                        isPrimary = true
                    ) {
                        vm.editAccount(
                            idUser = id,
                            editCustomerAccount = EditCustomerAccount(
                                emailActual = email,
                                emailNew = newEmail,
                                password = password,
                                passwordNew = newPassword
                            ),
                            onNavigateSuccess = {
                                onNavigateSuccessEdit(
                                    id.toString()
                                )
                            },
                            sharedPreferences = sharedPreferences,
                        )
                    }

                    Spacer(modifier = Modifier.height(20.dp))

                    ButtonGeneric(
                        text = "Opções",
                        textSize = 18,
                        modifier = Modifier
                            .width(270.dp)
                            .height(43.dp),
                        isPrimary = false
                    ) {
                        onNavigateConfiguration()
                    }
                }
            }
        }
    }
}

//@Preview(showBackground = true)
//@Composable
//fun EditAccountPreview() {
//    EditCustomerAccount()
//}