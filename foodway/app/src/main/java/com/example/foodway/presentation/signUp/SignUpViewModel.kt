package com.example.foodway.presentation.signUp

import android.util.Log
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.foodway.domain.model.Culinary
import com.example.foodway.domain.signUp.model.SignUpCustomer
import com.example.foodway.domain.signUp.model.SignUpEstablishment
import com.example.foodway.domain.signUp.usecase.CreateUserUseCase
import com.example.foodway.domain.signUp.usecase.GetAllCulinariesUseCase
import com.example.foodway.presentation.MainScreenState
import kotlinx.coroutines.launch
import retrofit2.HttpException

class SignUpViewModel(
    private val createUserUseCase: CreateUserUseCase,
    private val getAllCulinariesUseCase: GetAllCulinariesUseCase,
//    private val sharedPreferences: SharedPreferences
) : ViewModel() {

    val state = MutableLiveData<MainScreenState>(MainScreenState.Loading)


//    private val sharedPreferences: SharedPreferences by lazy {
//        context.getSharedPreferences("user_session", Context.MODE_PRIVATE)
//    }

//    fun savePersonalInfo(
//        name: String,
//        lastName: String,
//        cpf: String,
//        email: String,
//        password: String
//    ) {
//        with(sharedPreferences.edit()) {
//            putString("name", name)
//            putString("lastName", lastName)
//            putString("cpf", cpf)
//            putString("email", email)
//            putString("password", password)
//            apply()
//        }
//    }

//    fun clearSession() {
//        sharedPreferences.edit().clear().apply()
//    }

    val name = mutableStateOf("")
    val lastName = mutableStateOf("")
    val cpf = mutableStateOf("")
    val email = mutableStateOf("")
    val password = mutableStateOf("")
    val culinaries = mutableStateListOf<Culinary>()
    val fantasyName = mutableStateOf("")
    val responsible = mutableStateOf("")
    val cnpj = mutableIntStateOf(0)
    val cep = mutableIntStateOf(0)
    val number = mutableStateOf("")


    fun updateName(newValue: String) {
        name.value = newValue
    }

    fun updateLastName(newValue: String) {
        lastName.value = newValue
    }

    fun updateCPF(newValue: String) {
        cpf.value = newValue
    }

    fun updateEmail(newValue: String) {
        email.value = newValue
    }

    fun updatePassword(newValue: String) {
        password.value = newValue
    }

    fun toggleCulinary(culinary: Culinary) {
        if (culinaries.contains(culinary)) {
            culinaries.remove(culinary)
        } else {
            culinaries.add(culinary)
        }
    }

    fun createUser(
        signUpCustomer: SignUpCustomer? = null,
        signUpEstablishment: SignUpEstablishment? = null,
        onNavigateSuccessSignUp: () -> Unit = {},
    ) {
        viewModelScope.launch {
            try {
                state.value = MainScreenState.Loading

                val response = when {
                    signUpCustomer != null -> createUserUseCase(signUpCustomer)
                    signUpEstablishment != null -> createUserUseCase(signUpEstablishment)
                    else -> throw IllegalArgumentException("No sign-up data provided")
                }

                Log.d("SignUpViewModel", "Loading success: $response")
                onNavigateSuccessSignUp()

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

    fun getAllCulinaries() {
        viewModelScope.launch {
            try {
                state.value = MainScreenState.Loading
                Log.d("SignUpViewModel", "Loading started")
                val response = getAllCulinariesUseCase()
                state.value = MainScreenState.Success(data = response)
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
