package com.example.foodway.presentation.edit

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.foodway.domain.edit.customer.model.EditCustomerAccount
import com.example.foodway.domain.edit.customer.model.EditCustomerProfile
import com.example.foodway.domain.edit.customer.usecase.UpdateAccountUseCase
import com.example.foodway.domain.edit.customer.usecase.UpdateProfileUseCase
import com.example.foodway.domain.edit.establishment.model.EditEstablishmentAccount
import com.example.foodway.domain.edit.establishment.model.EditEstablishmentProfile
import com.example.foodway.presentation.MainScreenState
import kotlinx.coroutines.launch
import retrofit2.HttpException
import java.util.UUID

class EditViewModel(
    private val updateAccountUseCase: UpdateAccountUseCase,
    private val updateProfileUseCase: UpdateProfileUseCase
) : ViewModel() {
    val state = MutableLiveData<MainScreenState>(MainScreenState.Loading)

    fun editAccount(
        idCustomer: UUID? = null,
        idEstablishment: UUID? = null,
        editCustomerAccount: EditCustomerAccount? = null,
        editEstablishmentAccount: EditEstablishmentAccount? = null,
        onNavigateSuccess: () -> Unit = {},
    ) {
        viewModelScope.launch {
            try {
                state.value = MainScreenState.Loading

                val response = when {
                    editCustomerAccount != null -> idCustomer?.let {
                        updateAccountUseCase(
                            idCustomer = it,
                            editCustomerAccount = editCustomerAccount
                        )
                    }

                    editEstablishmentAccount != null -> idEstablishment?.let {
                        updateAccountUseCase(
                            idEstablishment = it,
                            editEstablishmentAccount = editEstablishmentAccount
                        )
                    }

                    else -> throw IllegalArgumentException("No edit account data provided")
                }

                Log.d("SignUpViewModel", "Loading success: $response")
                onNavigateSuccess()

            } catch (e: HttpException) {
                Log.e("SignUpViewModel", "HTTP Exception: ${e.message()}")
                val message = when (e.code()) {
                    404 -> "Culinária não encontrada"
                    400 -> "Parâmetros incorretos"
                    else -> "Erro desconhecido"
                }
                state.value = MainScreenState.Error(message)
            } catch (e: Exception) {
                Log.e("SignUpViewModel", "Exception: ${e.message}")
                state.value = MainScreenState.Error(
                    e.message ?: "Erro desconhecido"
                )
            }
        }
    }

    fun editProfile(
        idCustomer: UUID? = null,
        idEstablishment: UUID? = null,
        editCustomerProfile: EditCustomerProfile? = null,
        editEstablishmentProfile: EditEstablishmentProfile? = null,
        onNavigateSuccess: () -> Unit = {},
    ) {
        viewModelScope.launch {
            try {
                state.value = MainScreenState.Loading

                val response = when {
                    editCustomerProfile != null -> idCustomer?.let {
                        updateProfileUseCase(
                            idCustomer = it,
                            editCustomerProfile = editCustomerProfile
                        )
                    }

                    editEstablishmentProfile != null -> idEstablishment?.let {
                        updateProfileUseCase(
                            idEstablishment = it,
                            editEstablishmentProfile = editEstablishmentProfile
                        )
                    }

                    else -> throw IllegalArgumentException("No edit account data provided")
                }

                Log.d("SignUpViewModel", "Loading success: $response")
                onNavigateSuccess()

            } catch (e: HttpException) {
                Log.e("SignUpViewModel", "HTTP Exception: ${e.message()}")
                val message = when (e.code()) {
                    404 -> "Culinária não encontrada"
                    400 -> "Parâmetros incorretos"
                    else -> "Erro desconhecido"
                }
                state.value = MainScreenState.Error(message)
            } catch (e: Exception) {
                Log.e("SignUpViewModel", "Exception: ${e.message}")
                state.value = MainScreenState.Error(
                    e.message ?: "Erro desconhecido"
                )
            }
        }
    }
}