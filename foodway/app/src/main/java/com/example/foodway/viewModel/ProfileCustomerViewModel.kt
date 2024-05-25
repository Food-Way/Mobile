package com.example.foodway.viewModel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.foodway.domain.profile.customer.model.ProfileCustomer
import com.example.foodway.domain.repository.ICustomerRepository
import kotlinx.coroutines.launch
import retrofit2.HttpException
import java.util.UUID

class ProfileCustomerViewModel(
    private val repository: ICustomerRepository
) : ViewModel() {

    val state = MutableLiveData<MainScreenState>(MainScreenState.Loading)

    fun getCustomerProfile(
        idCustomer: UUID
    ) {
        viewModelScope.launch {
            try {
                state.value = MainScreenState.Loading
                Log.d("SignUpViewModel", "Loading started")
                val response = repository.getCustomerProfile(idCustomer)

                Log.d("response antes do IF", response.toString())

                if (response.isSuccessful) {
                    Log.d("response dentro do if", response.toString())

                    val response = response.body() ?: emptyList<ProfileCustomer>()
                    state.value = MainScreenState.Success(data = response)

                    Log.d("SignUpViewModel", "Loading success: $response")
                } else {
                    throw Exception("Erro desconhecido: HTTP ${response.code()}")
                }
                Log.d("response depois do if / else", response.toString())
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
