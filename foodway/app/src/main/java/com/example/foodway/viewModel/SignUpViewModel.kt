package com.example.foodway.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.foodway.api.ApiConfig
import com.example.foodway.model.Culinary
import com.example.foodway.service.CulinariesService
import kotlinx.coroutines.launch
import retrofit2.HttpException

class SignUpViewModel(
    private val repository: IMusicaRepository
) : ViewModel() {

    val state = MutableLiveData<MainScreenState>(MainScreenState.Loading)


    fun getAllMusicas() {
        viewModelScope.launch {
            try {
                state.value = MainScreenState.Loading

                val response = repository.getAll()

                if (response.isSuccessful) {
                    val list = response.body() ?: emptyList()
                    state.value = MainScreenState.Success(data = list)
                } else {
                    throw Exception("Erro desconhecido")
                }
            } catch (e: HttpException) {
                val message = when (e.code()) {
                    400 -> "Música não encontrada"
                    404 -> "Parâmetros incorretos"
                    else -> "Erro desconhecido"
                }
                state.value = MainScreenState.Error(message)
            } catch (e: Exception) {
                state.value = MainScreenState.Error(
                    e.message ?: "Erro desconhecido"
                )
            }
        }
    }
}
