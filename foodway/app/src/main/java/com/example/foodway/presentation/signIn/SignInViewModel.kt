package com.example.foodway.presentation.signIn

import android.content.Context
import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.foodway.domain.model.ETypeUser
import com.example.foodway.domain.signIn.model.SignIn
import com.example.foodway.domain.signIn.usecase.GetUserUseCase
import com.example.foodway.presentation.MainScreenState
import com.example.foodway.presentation.navigation.AppDestination
import com.example.foodway.utils.Destination
import com.example.foodway.utils.PreferencesManager
import com.example.foodway.utils.ProfileId
import kotlinx.coroutines.launch
import retrofit2.HttpException

class SignInViewModel(
    private val getUserUseCase: GetUserUseCase,
    context: Context
) : ViewModel() {
    val state = MutableLiveData<MainScreenState>(MainScreenState.Loading)

    private val sharedPreferences = PreferencesManager(context)

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
                Log.d("login", response.toString())

                response.let {
                    sharedPreferences.saveAuthenticatedData("id", it.idUser.toString() ?: "")
                    sharedPreferences.saveAuthenticatedData("token", it.token ?: "")
                    sharedPreferences.saveAuthenticatedData("photo", "https://foodway.s3.amazonaws.com/public-images/vietnam.webp" ?: "")
                    sharedPreferences.saveAuthenticatedData("name", it.name ?: "")
                    sharedPreferences.saveAuthenticatedData("typeUser", it.typeUser ?: "")
                    val route = when (it.typeUser) {
                        ETypeUser.CLIENT.name -> {
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