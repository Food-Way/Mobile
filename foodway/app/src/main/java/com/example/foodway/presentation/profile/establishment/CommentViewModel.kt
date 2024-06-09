package com.example.foodway.presentation.profile.establishment

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.foodway.domain.profile.establishment.model.PostComment
import com.example.foodway.domain.profile.establishment.usecase.PostCommentUseCase
import com.example.foodway.presentation.MainScreenState
import com.example.foodway.presentation.navigation.AppDestination
import com.example.foodway.utils.Destination
import com.example.foodway.utils.ProfileId
import kotlinx.coroutines.launch
import retrofit2.HttpException

class CommentViewModel(
    private val postCommentUseCase: PostCommentUseCase
) : ViewModel() {

    var modalState = MutableLiveData(false)
        private set

    fun toggleModal(showModal: Boolean = true) {
        modalState.value = showModal
    }

    val state = MutableLiveData<MainScreenState>(MainScreenState.Loading)

    fun postComment(
        token: String,
        postComment: PostComment,
        onPostCommentSuccess: (Destination, ProfileId) -> Unit,
    ) {
        viewModelScope.launch {
            try {
                state.value = MainScreenState.Loading
                Log.d("SignUpViewModel", "Comment$postComment")
                val response = postCommentUseCase(
                    token = token,
                    postComment = postComment
                )
                onPostCommentSuccess(
                    AppDestination.ProfileEstablishment.route,
                    postComment.idEstablishment.toString()
                )
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