package com.example.foodway.presentation.edit.customer

<<<<<<< Updated upstream
import androidx.compose.foundation.Image
=======
import ErrorView
import LoadingBar
import android.util.Log
import androidx.compose.foundation.background
>>>>>>> Stashed changes
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
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
<<<<<<< Updated upstream
import androidx.compose.ui.res.painterResource
=======
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
>>>>>>> Stashed changes
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.foodway.R
import com.example.foodway.presentation.components.ButtonGeneric

@Composable
fun EditCustomerProfile() {
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

<<<<<<< Updated upstream
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
                text = stringResource(id = R.string.change_profile),
                modifier = Modifier
                    .width(320.dp)
                    .height(43.dp),
                isPrimary = false
            ) {}

            Spacer(modifier = Modifier.height(30.dp))

//            LazyColumn{
//                items(profileCustomerInputInfos.size) { item ->
//                    InputGeneric(
//                        inputLabel = profileCustomerInputInfos[item].inputLabel,
//                        icon = profileCustomerInputInfos[item].icon,
//                        keyboardOptions = KeyboardOptions(
//                            keyboardType = profileCustomerInputInfos[item].type
//                        )
//                    )
//                }
//            }

            Spacer(modifier = Modifier.height(30.dp))

            ButtonGeneric(
                text = stringResource(id = R.string.save),
                modifier = Modifier
                    .width(320.dp)
                    .height(43.dp),
                isPrimary = true
            ) {}

            Spacer(modifier = Modifier.height(20.dp))

            ButtonGeneric(
                text = stringResource(id = R.string.edit_account),
                modifier = Modifier
                    .width(320.dp)
                    .height(43.dp),
                isPrimary = false
            ) {}
=======
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
>>>>>>> Stashed changes
        }
    }
}

@Preview(showBackground = true)
@Composable
fun EditProfilePreview() {
    EditCustomerProfile()
}