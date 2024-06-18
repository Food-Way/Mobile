package com.example.foodway.presentation.signUp.establishment

import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import com.example.foodway.domain.signUp.model.SignUpEstablishment
import com.example.foodway.presentation.signUp.SignUpViewModel

@Composable
fun SignUpEstablishment(
    vm: SignUpViewModel,
    onNavigateSuccessSignUp: () -> Unit,
) {
    var step by remember { mutableStateOf(1) }

    Scaffold { innerPadding ->
        when (step) {
            1 -> StepOneEstablishment(
                modifier = Modifier.padding(innerPadding),
                onStepComplete = { step = 2 },
                onGoBack = {},
                vm = vm
            )

            2 -> StepTwoEstablishment(
                modifier = Modifier.padding(innerPadding),
                onStepComplete = { step = 3 },
                onGoBack = { step = 1 },
                vm = vm
            )

            3 -> StepThreeEstablishment(
                modifier = Modifier.padding(innerPadding),
                onStepComplete = { step = 4 },
                onGoBack = { step = 2 },
                vm = vm
            )

            4 -> StepFourEstablishment(
                modifier = Modifier.padding(innerPadding),
                onGoBack = { step = 3 },
                vm = vm,
                onSignUpComplete = {
                    vm.createUser(
                        signUpEstablishment = SignUpEstablishment(
                            fantasyName = vm.fantasyName.value,
                            responsible = vm.responsible.value,
                            email = vm.email.value,
                            password = vm.password.value,
                            cnpj = vm.cnpj.intValue,
                            cep = vm.cep.intValue,
                            number = vm.number.value,
                            categories = vm.culinaries
                        ),
                        onNavigateSuccessSignUp = { onNavigateSuccessSignUp() }
                    )
                }
            )
        }
    }
}