package com.example.foodway.viewModel

import android.content.SharedPreferences
import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.foodway.model.Login
import com.example.foodway.repository.ISignInRepository
import kotlinx.coroutines.launch
import retrofit2.HttpException
import java.util.UUID

class SignInViewModel(
    private val repository: ISignInRepository,
    private val sharedPreferences: SharedPreferences
) : ViewModel() {
    val state = MutableLiveData<MainScreenState>(MainScreenState.Loading)

    fun saveAuthenticatedData(
        id: UUID
    ) {
        sharedPreferences.edit().putString("id", id.toString()).apply()
    }


    fun login(
        email: String,
        password: String,
        onNavigateSuccessLogin: (String) -> Unit = {},
    ) {
        viewModelScope.launch {
            try {
                state.value = MainScreenState.Loading
                Log.d("SignUpViewModel", "Loading started")
                val loginData = Login(email, password)
                val response = repository.login(loginData)

                Log.d("response antes do IF", response.toString())

                if (response.isSuccessful) {
                    val customer = response.body()

                    if (customer != null) {
                        Log.d("response dentro do if", response.toString())
                        saveAuthenticatedData(customer.idUser)
                        state.value = MainScreenState.Success(data = customer)
                        Log.d("SignInViewModel", "Loading success: $customer")
                        onNavigateSuccessLogin(response.body()!!.idUser.toString())
                    } else {
                        Log.e("SignInViewModel", "Erro: Corpo da resposta é nulo")
                        state.value = MainScreenState.Error("Erro: Corpo da resposta é nulo")
                    }
                }
                Log.d("response depois do if / else", response.toString())
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