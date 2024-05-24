package com.example.foodway.viewModel

import android.content.SharedPreferences
import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.foodway.model.Login
import com.example.foodway.model.UserType
import com.example.foodway.repository.ISignInRepository
import com.example.foodway.view.navigation.AppDestination
import kotlinx.coroutines.launch
import retrofit2.HttpException
import java.util.UUID

typealias ProfileId = String
typealias Destination = String

class SignInViewModel(
    private val repository: ISignInRepository,
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
                val loginData = Login(email, password)
                val response = repository.login(loginData)

                Log.d("response antes do IF", response.toString())

                if (response.isSuccessful) {
                    val profile = response.body()
                    profile?.let {
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
                    } ?: run {
                        Log.d("LOGIN", "Logou, mas trouxe perfil null")
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