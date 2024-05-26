package com.example.foodway.presentation.searchUser

import android.content.SharedPreferences
import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.foodway.domain.searchUser.usecase.GetCustomerUseCase
import com.example.foodway.domain.searchUser.usecase.GetEstablishmentUseCase
import com.example.foodway.domain.searchUser.usecase.GetFavoriteUseCase
import com.example.foodway.presentation.MainScreenState
import kotlinx.coroutines.launch
import retrofit2.HttpException
import java.util.UUID

class SearchUserViewModel(
    private val getCustomerUseCase: GetCustomerUseCase,
    private val getFavoriteUseCase: GetFavoriteUseCase,
    private val getEstablishmentUseCase: GetEstablishmentUseCase,
    private val sharedPreferences: SharedPreferences
) : ViewModel() {
    val state = MutableLiveData<MainScreenState>(MainScreenState.Loading)

    fun getSavedAuthentication(): UUID {
        val idString = sharedPreferences.getString("id", null)
        return UUID.fromString(idString)
    }

    fun getAllEstablishments() {
        viewModelScope.launch {
            try {
                state.value = MainScreenState.Loading
                Log.d("SearchUserViewModel", "Loading started")

                val response = getEstablishmentUseCase(idSession = getSavedAuthentication())
                state.value = MainScreenState.Success(data = response)

                Log.d("response antes do IF", response.toString())
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

    fun getAllCustomers() {
        val state = MutableLiveData<MainScreenState>(MainScreenState.Loading)

        viewModelScope.launch {
            try {
                state.value = MainScreenState.Loading
                Log.d("SearchUserViewModel", "Loading started")
                val response = getCustomerUseCase(idSession = getSavedAuthentication())
                state.value = MainScreenState.Success(data = response)
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

    fun getAllFavorites() {
        val state = MutableLiveData<MainScreenState>(MainScreenState.Loading)

        viewModelScope.launch {
            try {
                state.value = MainScreenState.Loading
                Log.d("SearchUserViewModel", "Loading started")
                val response = getFavoriteUseCase(idSession = getSavedAuthentication())
                state.value = MainScreenState.Success(data = response)
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