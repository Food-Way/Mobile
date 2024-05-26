package com.example.foodway.presentation.signIn

import android.content.SharedPreferences
import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.foodway.domain.model.UserType
import com.example.foodway.domain.signIn.model.SignIn
import com.example.foodway.domain.signIn.usecase.GetUserUseCase
import com.example.foodway.presentation.MainScreenState
import com.example.foodway.presentation.navigation.AppDestination
import com.example.foodway.utils.Destination
import com.example.foodway.utils.ProfileId
import kotlinx.coroutines.launch
import retrofit2.HttpException
import java.util.UUID

class SignInViewModel(
    private val getUserUseCase: GetUserUseCase,
    private val sharedPreferences: SharedPreferences
) : ViewModel() {
    val state = MutableLiveData<MainScreenState>(MainScreenState.Loading)

    private fun saveAuthenticatedData(
        id: UUID
    ) {
        sharedPreferences
            .edit()
            .putString("id", id.toString())
            .apply()
    }

    fun login(
        email: String,
        password: String,
        onNavigateSuccessSignInTo: (Destination, ProfileId) -> Unit,
    ) {
        viewModelScope.launch {
            try {
                state.value = MainScreenState.Loading
                Log.d("SignUpViewModel", "Loading started")

                val signInData = SignIn(email, password)
                val response = getUserUseCase(signIn = signInData)

                response.let {
                    saveAuthenticatedData(it.idUser)
                    val route = when (it.typeUser) {
                        UserType.CLIENT.name -> {
                            AppDestination.ProfileCustomer.route
                        }
                        else -> {
                            AppDestination.ProfileEstablishment.route
                        }
                    }
                    with(it.idUser) {
                        onNavigateSuccessSignInTo(route, this.toString())
                    }
                }
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