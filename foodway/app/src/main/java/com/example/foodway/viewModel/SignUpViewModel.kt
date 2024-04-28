package com.example.foodway.viewModel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.foodway.MainScreenState
import com.example.foodway.repository.ICulinaryRepository
import kotlinx.coroutines.launch
import retrofit2.HttpException

class SignUpViewModel(
    private val repository: ICulinaryRepository
) : ViewModel() {

    val state = MutableLiveData<MainScreenState>(MainScreenState.Loading)

    fun getAllCulinaries() {
        viewModelScope.launch {
            try {
                state.value = MainScreenState.Loading

                val response = repository.getAllCulinaries()

                if (response.isSuccessful) {
                    val list = response.body() ?: emptyList<Any>()
                    state.value = MainScreenState.Success(data = list)
                    Log.e("TAG", "My Object:: $list")
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
