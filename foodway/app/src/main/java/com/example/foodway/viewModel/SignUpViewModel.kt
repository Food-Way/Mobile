package com.example.foodway.viewModel

import android.util.Log
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.foodway.model.Culinary
import com.example.foodway.model.SignUpCustomer
import com.example.foodway.repository.ICulinaryRepository
import com.example.foodway.repository.ICustomerRepository
import com.example.foodway.repository.IEstablishmentRepository
import kotlinx.coroutines.launch
import retrofit2.HttpException

class SignUpViewModel(
    private val culinaryRepository: ICulinaryRepository,
    private val customerRepository: ICustomerRepository,
    private val establishmentRepository: IEstablishmentRepository,
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

    var name = mutableStateOf("")
        private set
    var lastName = mutableStateOf("")
        private set
    var cpf = mutableStateOf("")
        private set
    var email = mutableStateOf("")
        private set
    var password = mutableStateOf("")
        private set
    var fantasyName = mutableStateOf("")
        private set
    var responsible = mutableStateOf("")
        private set
    var culinaries = mutableStateListOf<Culinary>()
        private set
    var cnpj = mutableStateOf("")
        private set
    var cep = mutableStateOf("")
        private set
    var address = mutableStateOf("")
        private set
    var states = mutableStateOf("")
        private set
    var number = mutableStateOf("")
        private set

    fun updateCNPJ(newValue: String) {
        cnpj.value = newValue
    }

    fun updateCEP(newValue: String) {
        cep.value = newValue
    }

    fun updateAddress(newValue: String) {
        address.value = newValue
    }

    fun updateState(newValue: String) {
        states.value = newValue
    }

    fun updateNumber(newValue: String) {
        number.value = newValue
    }


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

    fun updateFantasyName(newValue: String) {
        fantasyName.value = newValue
    }

    fun updateResponsible(newValue: String) {
        responsible.value = newValue
    }


    fun toggleCulinary(culinary: Culinary) {
        if (culinaries.contains(culinary)) {
            culinaries.remove(culinary)
        } else {
            culinaries.add(culinary)
        }
    }

    fun signUpCustomer(
        name: String,
        lastName: String,
        cpf: String,
        email: String,
        password: String,
        onNavigateSuccessSignUp: () -> Unit = {},
    ) {
        viewModelScope.launch {
            try {
                state.value = MainScreenState.Loading
                Log.d("SignUpViewModel", "Loading started")

                val signUpCustomerData = SignUpCustomer(
                    name = name,
                    lastName = lastName,
                    cpf = cpf,
                    email = email,
                    password = password,
                    categories = culinaries.toList()
                )
                Log.d("signUpCustomerData", signUpCustomerData.toString())
                val response = customerRepository.postCustomer(
                    signUpCustomer = signUpCustomerData
                )

                Log.d("response antes do IF", response.toString())

                if (response.isSuccessful) {
                    Log.d("response dentro do if", response.toString())
                    val response = response.body() ?: emptyList<Culinary>()
                    state.value = MainScreenState.Success(data = response)
                    Log.d("SignUpViewModel", "Loading success: $response")
                    onNavigateSuccessSignUp()
                } else {
                    throw Exception("Erro desconhecido: HTTP ${response.code()}")
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

    fun getAllCulinaries() {
        viewModelScope.launch {
            try {
                state.value = MainScreenState.Loading
                Log.d("SignUpViewModel", "Loading started")
                val response = culinaryRepository.getAllCulinaries()

                Log.d("response antes do IF", response.toString())

                if (response.isSuccessful) {
                    Log.d("response dentro do if", response.toString())
                    val response = response.body() ?: emptyList<Culinary>()
                    state.value = MainScreenState.Success(data = response)
                    Log.d("SignUpViewModel", "Loading success: $response")
                } else {
                    throw Exception("Erro desconhecido: HTTP ${response.code()}")
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
