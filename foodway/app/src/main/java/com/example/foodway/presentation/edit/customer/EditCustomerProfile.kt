package com.example.foodway.presentation.edit.customer

import android.content.Context
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
import com.example.foodway.domain.model.CustomerInputManager.profileCustomerInputInfos
import com.example.foodway.presentation.components.ButtonGeneric
import com.example.foodway.presentation.components.InputGeneric
import com.example.foodway.presentation.edit.EditViewModel
import com.example.foodway.utils.PreferencesManager
import java.util.UUID

@Composable
fun EditCustomerProfile(
    vm: EditViewModel,
    context: Context
) {

    val sharedPreferences = PreferencesManager(context)

    var name by remember { mutableStateOf("") }
    var bio by remember { mutableStateOf("") }
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
                text = stringResource(id = R.string.change_profile),
                modifier = Modifier
                    .width(320.dp)
                    .height(43.dp),
                isPrimary = false
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

                Spacer(modifier = Modifier.height(30.dp))

                ButtonGeneric(
                    text = stringResource(id = R.string.save),
                    modifier = Modifier
                        .width(320.dp)
                        .height(43.dp),
                    isPrimary = true
                ) {
                    vm.editProfile(
                        UUID.fromString(sharedPreferences.getSavedData("id", "")),
                    )
                }

                Spacer(modifier = Modifier.height(20.dp))

                ButtonGeneric(
                    text = stringResource(id = R.string.edit_account),
                    modifier = Modifier
                        .width(320.dp)
                        .height(43.dp),
                    isPrimary = false
                ) {}
            }
        }
    }
}

//@Preview(showBackground = true)
//@Composable
//fun EditProfilePreview() {
//    EditCustomerProfile()
//}