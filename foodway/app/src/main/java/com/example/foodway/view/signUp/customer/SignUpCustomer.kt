package com.example.foodway.view.signUp.customer

import CategoryCard
import ErrorView
import LoadingBar
import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Scaffold
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
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.foodway.R
import com.example.foodway.model.Culinary
import com.example.foodway.model.CustomerInputManager
import com.example.foodway.ui.theme.FoodwayTheme
import com.example.foodway.view.components.ButtonGeneric
import com.example.foodway.view.components.CardGrid
import com.example.foodway.view.components.InputGeneric
import com.example.foodway.view.components.ScreenBorder
import com.example.foodway.viewModel.MainScreenState
import com.example.foodway.viewModel.SignUpViewModel

@Composable
fun SignUpCustomer(
    vm: SignUpViewModel,
    onNavigateSuccessSignIn: () -> Unit,
    ) {
    var step by remember { mutableStateOf(1) }

    Scaffold { innerPadding ->
        when (step) {
            1 -> StepOne(
                modifier = Modifier.padding(innerPadding),
                onStepComplete = { step = 2 },
                vm = vm
            )

            2 -> StepTwo(
                modifier = Modifier.padding(innerPadding),
                onStepComplete = { step = 3 },
                onGoBack = { step = 1 },
                vm = vm
            )

            3 -> StepThree(
                modifier = Modifier.padding(innerPadding),
                onSignUpComplete = {
                    vm.signUpCustomer(
                        name = vm.name.value,
                        lastName = vm.lastName.value,
                        cpf = vm.cpf.value,
                        email = vm.email.value,
                        password = vm.password.value,
                        onNavigateSuccessSignUp = {onNavigateSuccessSignIn()}
                    )
                },
                onGoBack = { step = 2 },
                vm = vm
            )
        }
    }
}


@Composable
fun StepOne(
    modifier: Modifier,
    onStepComplete: () -> Unit,
    vm: SignUpViewModel
) {
    var name by remember {
        mutableStateOf("")
    }

    var lastName by remember {
        mutableStateOf("")
    }

    var cpf by remember {
        mutableStateOf("")
    }

    var email by remember {
        mutableStateOf("")
    }

    var password by remember {
        mutableStateOf("")
    }

    var passwordConfirm by remember {
        mutableStateOf("")
    }

    FoodwayTheme {
        ScreenBorder {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight()
                    .padding(20.dp, 21.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.SpaceAround
            ) {
                Text(
                    fontWeight = FontWeight.Bold,
                    fontSize = 18.sp,
                    textAlign = TextAlign.Center,
                    text = stringResource(id = R.string.info_establishments)
                )

                Column {
                    InputGeneric(
                        inputLabel = CustomerInputManager.personalCustomerInputInfos[0].inputLabel,
                        icon = CustomerInputManager.personalCustomerInputInfos[0].icon,
                        keyboardOptions = KeyboardOptions(
                            keyboardType = CustomerInputManager.personalCustomerInputInfos[0].type
                        ),
                        visualTransformation = VisualTransformation.None,
                        labelState = name,
                        onValueChange = {
                            name = it
                            vm.updateName(name)
                        },
                    )

                    InputGeneric(
                        inputLabel = CustomerInputManager.personalCustomerInputInfos[1].inputLabel,
                        icon = CustomerInputManager.personalCustomerInputInfos[1].icon,
                        keyboardOptions = KeyboardOptions(
                            keyboardType = CustomerInputManager.personalCustomerInputInfos[1].type
                        ),
                        visualTransformation = VisualTransformation.None,
                        labelState = lastName,
                        onValueChange = {
                            lastName = it
                            vm.updateLastName(lastName)
                        },
                    )

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
                            vm.updateCPF(cpf)
                        },
                    )

                    InputGeneric(
                        inputLabel = CustomerInputManager.personalCustomerInputInfos[3].inputLabel,
                        icon = CustomerInputManager.personalCustomerInputInfos[3].icon,
                        keyboardOptions = KeyboardOptions(
                            keyboardType = CustomerInputManager.personalCustomerInputInfos[3].type
                        ),
                        visualTransformation = VisualTransformation.None,
                        labelState = email,
                        onValueChange = {
                            email = it
                            vm.updateEmail(email)
                        },
                    )

                    InputGeneric(
                        inputLabel = CustomerInputManager.personalCustomerInputInfos[4].inputLabel,
                        icon = CustomerInputManager.personalCustomerInputInfos[4].icon,
                        keyboardOptions = KeyboardOptions(
                            keyboardType = CustomerInputManager.personalCustomerInputInfos[4].type
                        ),
                        visualTransformation = PasswordVisualTransformation(),
                        labelState = password,
                        onValueChange = {
                            password = it
                            vm.updatePassword(password)
                        },
                    )

                    InputGeneric(
                        inputLabel = CustomerInputManager.personalCustomerInputInfos[5].inputLabel,
                        icon = CustomerInputManager.personalCustomerInputInfos[5].icon,
                        keyboardOptions = KeyboardOptions(
                            keyboardType = CustomerInputManager.personalCustomerInputInfos[2].type
                        ),
                        visualTransformation = PasswordVisualTransformation(),
                        labelState = passwordConfirm,
                        onValueChange = {
                            passwordConfirm = it
                        },
                    )
                }

//                LazyColumn {
//                    items(CustomerInputManager.personalCustomerInputInfos.size) { item ->
//                        InputGeneric(
//                            inputLabel = CustomerInputManager.personalCustomerInputInfos[item].inputLabel,
//                            icon = CustomerInputManager.personalCustomerInputInfos[item].icon,
//                            keyboardOptions = KeyboardOptions(
//                                keyboardType = CustomerInputManager.personalCustomerInputInfos[item].type
//                            ),
//                            labelState = states[item],
//                            onValueChange = {
//                                states[item] = it
//                            }
//                        )
//                    }
//                }

                ButtonGeneric(
                    text = stringResource(id = R.string.next),
                    modifier = Modifier
                        .width(250.dp)
                        .height(45.dp),
                    isPrimary = false,
                    onClick = {
                        onStepComplete(

                        )
                    }
                )
            }
        }
    }


}

@Composable
fun StepTwo(
    modifier: Modifier,
    onStepComplete: () -> Unit,
    onGoBack: () -> Unit,
    vm: SignUpViewModel
) {
    var culinaries by remember {
        mutableStateOf(mutableListOf<Culinary>())
    }

    val state by vm.state.observeAsState()
    FoodwayTheme {
        ScreenBorder {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight(.8f)
                    .padding(20.dp, 21.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
            ) {
                Text(
                    fontWeight = FontWeight.Bold,
                    fontSize = 18.sp,
                    textAlign = TextAlign.Center,
                    text = stringResource(id = R.string.taste_selection)
                )

                when (state) {
                    is MainScreenState.Loading -> {
                        Log.d("loading", "loading state")
                        LoadingBar(
                            loadingText = "Carregando culinárias..."
                        )
                        vm.getAllCulinaries()
                    }

                    is MainScreenState.Error, null -> {
                        val errorMessage = (state as MainScreenState.Error).message
                        Log.d("Error", "Error state")
                        ErrorView(message = errorMessage) {
                            vm.getAllCulinaries()
                        }
                    }

                    is MainScreenState.Success<*> -> {
                        val culinaries =
                            (state as MainScreenState.Success<Culinary>).data as List<Culinary>
                        Log.d("Success", "Success state")
                        CardGrid(culinaries, buildItem = { culinary ->
                            CategoryCard(culinary) { clickedCulinary ->
                                vm.toggleCulinary(clickedCulinary)
                            }
                        })
                    }
                }

            }
            ButtonGeneric(
                text = stringResource(id = R.string.next),
                modifier = Modifier
                    .width(250.dp)
                    .height(45.dp),
                isPrimary = false,
                onClick = {
                    onStepComplete()
                }
            )
        }
    }
}

@Composable
fun StepThree(
    modifier: Modifier,
    onSignUpComplete: () -> Unit,
    onGoBack: () -> Unit,
    vm: SignUpViewModel
) {
    FoodwayTheme {
        ScreenBorder {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight()
                    .padding(20.dp, 21.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.SpaceAround
            ) {
                Text(
                    fontWeight = FontWeight.Bold,
                    fontSize = 18.sp,
                    textAlign = TextAlign.Center,
                    text = stringResource(id = R.string.conclusion_title)
                )

                Text(
                    fontWeight = FontWeight.Bold,
                    text = stringResource(id = R.string.sign_up_sucess_title)
                )

                Text(
                    textAlign = TextAlign.Justify,
                    text = stringResource(id = R.string.congrat_text),
                    modifier = Modifier.fillMaxWidth()
                )
                Image(
                    painter = painterResource(id = R.drawable.sign_up_finish_image),
                    contentDescription = stringResource(id = R.string.conclusion_image_desc),
                    modifier = Modifier
                        .width(240.dp)
                        .height(160.dp)
                )

                ButtonGeneric(
                    text = stringResource(id = R.string.conclusion_button),
                    modifier = Modifier
                        .width(250.dp)
                        .height(45.dp),
                    isPrimary = true,
                    onClick = {
                        onSignUpComplete()
                    }
                )
            }
        }
    }
}