package com.example.foodway.presentation.establishmentMenu

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.foodway.domain.establishmentMenu.usecase.GetEstablishmentMenuUseCase
import com.example.foodway.presentation.MainScreenState
import kotlinx.coroutines.launch
import retrofit2.HttpException
import java.util.UUID

class MenuEstablishmentViewModel(
    private val getEstablishmentMenuUseCase: GetEstablishmentMenuUseCase,
) : ViewModel() {

    val state = MutableLiveData<MainScreenState>(MainScreenState.Loading)

    fun getEstablishmentMenu(
        idEstablishment: UUID
    ) {
        viewModelScope.launch {
            try {
                state.value = MainScreenState.Loading
                Log.d("SignUpViewModel", "Loading started")
                val response = getEstablishmentMenuUseCase(
                    idEstablishment = idEstablishment,
                    orderBy = "name"
                )
                Log.d("menu", response.toString())
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