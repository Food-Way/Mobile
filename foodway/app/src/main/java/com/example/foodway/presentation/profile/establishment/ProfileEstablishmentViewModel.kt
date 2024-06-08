package com.example.foodway.presentation.profile.establishment

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.foodway.domain.profile.establishment.model.PostComment
import com.example.foodway.domain.profile.establishment.usecase.GetEstablishmentProfileUseCase
import com.example.foodway.domain.profile.establishment.usecase.PostCommentUseCase
import com.example.foodway.presentation.MainScreenState
import kotlinx.coroutines.launch
import retrofit2.HttpException
import java.util.UUID

class ProfileEstablishmentViewModel(
    private val getEstablishmentProfileUseCase: GetEstablishmentProfileUseCase,
    private val postCommentUseCase: PostCommentUseCase
) : ViewModel() {

    var modalState = MutableLiveData(false)
        private set

    fun toggleModal(showModal: Boolean = true) {
        modalState.value = showModal
    }

    val state = MutableLiveData<MainScreenState>(MainScreenState.Loading)

    fun getEstablishmentProfile(
        idEstablishment: UUID
    ) {
        viewModelScope.launch {
            try {
                state.value = MainScreenState.Loading
                Log.d("SignUpViewModel", "Loading started")
                val response = getEstablishmentProfileUseCase(idEstablishment = idEstablishment)
                state.value = MainScreenState.Success(data = response)
            } catch (e: HttpException) {
                Log.e("SignUpViewModel", "HTTP Exception: ${e.message()}")
                val message = when (e.code()) {
                    404 -> "Perfil não encontrado"
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

    fun postComment(postComment: PostComment){
        viewModelScope.launch {
            try {
                state.value = MainScreenState.Loading
                Log.d("SignUpViewModel", "Loading started")
                val response = postCommentUseCase(postComment = postComment)
                state.value = MainScreenState.Success(data = response)
            } catch (e: HttpException) {
                Log.e("SignUpViewModel", "HTTP Exception: ${e.message()}")
                val message = when (e.code()) {
                    404 -> "Perfil não encontrado"
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