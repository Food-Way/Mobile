package com.example.foodway.viewModel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.foodway.model.ProfileCustomer
import com.example.foodway.model.SearchUser
import com.example.foodway.repository.ISearchUserRepository
import kotlinx.coroutines.launch
import retrofit2.HttpException

class SearchUserViewModel(
    private val repository: ISearchUserRepository
) : ViewModel() {
    val state = MutableLiveData<MainScreenState>(MainScreenState.Loading)

    fun getUsersEstablishment() {
        viewModelScope.launch {
            try {
                state.value = MainScreenState.Loading
                Log.d("SearchUserViewModel", "Loading started")
                val response = repository.getUsersEstablishment()

                Log.d("response antes do IF", response.toString())

                if (response.isSuccessful) {
                    Log.d("response dentro do if", response.toString())

                    val response = response.body() ?: emptyList<SearchUser>()
                    state.value = MainScreenState.Success(data = response)

                    Log.d("SearchUserViewModel", "Loading success: $response")
                } else {
                    throw Exception("Erro desconhecido: HTTP ${response.code()}")
                }
                Log.d("response depois do if / else", response.toString())
            } catch (e: HttpException) {
                Log.e("SearchUserViewModel", "HTTP Exception: ${e.message()}")
                val message = when (e.code()) {
                    404 -> "Estabelecimentos não encontrados"
                    400 -> "Requisição incorreta"
                    else -> "Erro desconhecido"
                }
                state.value = MainScreenState.Error(message)
            } catch (e: Exception) {
                Log.e("SearchUserViewModel", "Exception: ${e.message}")
                state.value = MainScreenState.Error(
                    e.message ?: "Erro desconhecido"
                )
            }
        }
    }

    fun getUsersCustomer() {
        val state = MutableLiveData<MainScreenState>(MainScreenState.Loading)

        viewModelScope.launch {
            try {
                state.value = MainScreenState.Loading
                Log.d("SearchUserViewModel", "Loading started")
                val response = repository.getUsersCustomer()

                Log.d("response antes do IF", response.toString())

                if (response.isSuccessful) {
                    Log.d("response dentro do if", response.toString())

                    val response = response.body() ?: emptyList<SearchUser>()
                    state.value = MainScreenState.Success(data = response)

                    Log.d("SearchUserViewModel", "Loading success: $response")
                } else {
                    throw Exception("Erro desconhecido: HTTP ${response.code()}")
                }
                Log.d("response depois do if / else", response.toString())
            } catch (e: HttpException) {
                Log.e("SearchUserViewModel", "HTTP Exception: ${e.message()}")
                val message = when (e.code()) {
                    404 -> "Clientes não encontrados"
                    400 -> "Requisição incorreta"
                    else -> "Erro desconhecido"
                }
                state.value = MainScreenState.Error(message)
            } catch (e: Exception) {
                Log.e("SearchUserViewModel", "Exception: ${e.message}")
                state.value = MainScreenState.Error(
                    e.message ?: "Erro desconhecido"
                )
            }
        }
    }

    fun getFavorites() {
        val state = MutableLiveData<MainScreenState>(MainScreenState.Loading)

        viewModelScope.launch {
            try {
                state.value = MainScreenState.Loading
                Log.d("SearchUserViewModel", "Loading started")
                val response = repository.getUsersEstablishment()

                Log.d("response antes do IF", response.toString())

                if (response.isSuccessful) {
                    Log.d("response dentro do if", response.toString())

                    val response = response.body() ?: emptyList<SearchUser>()
                    state.value = MainScreenState.Success(data = response)

                    Log.d("SearchUserViewModel", "Loading success: $response")
                } else {
                    throw Exception("Erro desconhecido: HTTP ${response.code()}")
                }
                Log.d("response depois do if / else", response.toString())
            } catch (e: HttpException) {
                Log.e("SearchUserViewModel", "HTTP Exception: ${e.message()}")
                val message = when (e.code()) {
                    404 -> "Estabelecimentos não encontrados"
                    400 -> "Requisição incorreta"
                    else -> "Erro desconhecido"
                }
                state.value = MainScreenState.Error(message)
            } catch (e: Exception) {
                Log.e("SearchUserViewModel", "Exception: ${e.message}")
                state.value = MainScreenState.Error(
                    e.message ?: "Erro desconhecido"
                )
            }
        }
    }
}