package com.example.foodway.presentation.signIn

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.foodway.R
import com.example.foodway.presentation.components.ButtonGeneric
import com.example.foodway.presentation.components.InputGeneric
import com.example.foodway.utils.Destination
import com.example.foodway.utils.ProfileId

@Composable
fun SignIn(
    onNavigate: () -> Unit = {},
    onNavigateSuccessSignInTo: (Destination, ProfileId) -> Unit,
    vm: SignInViewModel
) {
    var email = remember { mutableStateOf("") }
    val password = remember { mutableStateOf("") }

    Box(
        modifier = Modifier
            .fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Box(
            modifier = Modifier
                .width(350.dp)
                .height(650.dp)
                .padding(16.dp)
                .border(2.dp, Color.LightGray, RoundedCornerShape(16.dp))
        ) {
            Column(
                modifier = Modifier.fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                Image(
                    painter = painterResource(id = R.drawable.foodway_logo),
                    contentDescription = stringResource(id = R.string.logo),
                    modifier = Modifier
                        .width(95.dp)
                        .height(98.dp)
                )
                Spacer(modifier = Modifier.height(10.dp))

                Text(
                    text = stringResource(id = R.string.welcome_title),
                    fontWeight = FontWeight.Bold,
                    fontSize = 18.sp,
                )

                InputGeneric(
                    inputLabel = R.string.email,
                    icon = R.drawable.email_icon,
                    keyboardOptions = KeyboardOptions(
                        keyboardType = KeyboardType.Email
                    ),
                    visualTransformation = VisualTransformation.None,
                    labelState = email.value,
                    onValueChange = {
                        email.value = it
                    },
                )

                Spacer(modifier = Modifier.height(15.dp))

                InputGeneric(
                    inputLabel = R.string.password,
                    icon = R.drawable.lock_icon,
                    keyboardOptions = KeyboardOptions(
                        keyboardType = KeyboardType.Password
                    ),
                    visualTransformation = PasswordVisualTransformation(),
                    labelState = password.value,
                    onValueChange = {
                        password.value = it
                    },
                )

                Spacer(modifier = Modifier.height(40.dp))

                ButtonGeneric(
                    text = stringResource(id = R.string.enter),
                    textSize = 18,
                    modifier = Modifier
                        .width(270.dp)
                        .height(43.dp),
                    isPrimary = true,
                    onClick = {
                        vm.login(
                            email = email.value,
                            password = password.value,
                            onNavigateSuccessSignInTo = onNavigateSuccessSignInTo
                        )
                    }
                )

                Spacer(modifier = Modifier.height(20.dp))

                Text(
                    text = stringResource(id = R.string.forget_password),
                    fontSize = 15.sp,
                    modifier = Modifier.clickable {
                    }
                )

                Spacer(modifier = Modifier.height(20.dp))

                Box(
                    modifier = Modifier
                        .border(1.dp, Color.LightGray)
                        .width(270.dp)
                        .height(1.dp)
                )

                Spacer(modifier = Modifier.height(20.dp))

                Text(
                    text = stringResource(id = R.string.havent_account),
                    fontSize = 15.sp,
                )
                Spacer(modifier = Modifier.height(20.dp))
                ButtonGeneric(
                    text = stringResource(id = R.string.signup),
                    textSize = 18,
                    modifier = Modifier
                        .width(150.dp)
                        .height(43.dp),
                    isPrimary = false,
                ) {
                    onNavigate()
                }
            }
        }
    }

}