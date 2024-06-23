package com.example.foodway.presentation.profile.customer

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.foodway.domain.profile.customer.usecase.GetCustomerProfileUseCase
import com.example.foodway.presentation.MainScreenState
import kotlinx.coroutines.launch
import retrofit2.HttpException
import java.util.UUID

class ProfileCustomerViewModel(
    private val getCustomerProfileUseCase: GetCustomerProfileUseCase,
) : ViewModel() {

    val state = MutableLiveData<MainScreenState>(MainScreenState.Loading)

    fun getCustomerProfile(
        idCustomer: UUID
    ) {
        viewModelScope.launch {
            try {
                state.value = MainScreenState.Loading
                val response = getCustomerProfileUseCase(idCustomer = idCustomer)
                Log.d("response", response.toString())
                state.value = MainScreenState.Success(data = response)
            } catch (e: HttpException) {
                Log.e("SignUpViewModel", "HTTP Exception: ${e.message()}")
                val message = when (e.code()) {
                    404 -> "Perfil não encontrado"
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
