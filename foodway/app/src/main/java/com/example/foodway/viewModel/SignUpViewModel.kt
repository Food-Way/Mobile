package com.example.foodway.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.foodway.api.ApiConfig
import com.example.foodway.model.Culinary
import com.example.foodway.service.CulinariesService
import kotlinx.coroutines.launch
import retrofit2.HttpException

class SignUpViewModel : ViewModel() {
    var isLoading = MutableLiveData(false)
        private set

    var isSuccess = MutableLiveData<List<Culinary>>(emptyList())
        private set

    var isError = MutableLiveData(false)

    var errorMessage = MutableLiveData("")

    fun getAllMusicas() {
        try {
            viewModelScope.launch {
                isLoading.value = true

                val culinaryRepository = ApiConfig
                    .getInstance()
                    .create(CulinariesService::class.java)

                val response = culinaryRepository.getAllCulinaries()

                if (response.isSuccessful) {
                    val list = response.body() ?: emptyList()
                    isSuccess.value = list
                    isLoading.value = false
                } else {
                    throw Exception("Erro desconhecido")
                }
            }
        } catch (e: HttpException) {
            val message = when (e.code()) {
                400 -> "Música não encontrada"
                404 -> "Parâmetros incorretos"
                else -> "Erro desconhecido"
            }
            isLoading.value = false
            isError.value = true
            errorMessage.value = message
        } catch (e: Exception) {
            isError.value = true
            errorMessage.value = e.message
            isLoading.value = false
        }
    }
}