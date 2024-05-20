package com.example.foodway.view.signUp.customer

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
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
                        onNavigateSuccessSignUp = { onNavigateSuccessSignIn() }
                    )
                },
                onGoBack = { step = 2 },
                vm = vm
            )
        }
    }
}