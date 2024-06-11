package com.example.foodway.presentation.profile.establishment

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.foodway.domain.model.Comment
import com.example.foodway.domain.profile.establishment.model.PatchUpvote
import com.example.foodway.domain.profile.establishment.model.PostComment
import com.example.foodway.domain.profile.establishment.usecase.GetEstablishmentProfileUseCase
import com.example.foodway.domain.profile.establishment.usecase.PatchUpvoteUseCase
import com.example.foodway.domain.profile.establishment.usecase.PostCommentUseCase
import com.example.foodway.presentation.MainScreenState
import com.example.foodway.presentation.navigation.AppDestination
import com.example.foodway.utils.Destination
import com.example.foodway.utils.ProfileId
import kotlinx.coroutines.launch
import retrofit2.HttpException
import java.util.UUID

class ProfileEstablishmentViewModel(
    private val getEstablishmentProfileUseCase: GetEstablishmentProfileUseCase,
    private val postCommentUseCase: PostCommentUseCase,
    private val patchUpvoteUseCase: PatchUpvoteUseCase
) : ViewModel() {

    val state = MutableLiveData<MainScreenState>(MainScreenState.Loading)

    var modalStateComment = MutableLiveData(false)
        private set

    var modalStateCommentReply = MutableLiveData(false)
        private set

    var commentSelected = MutableLiveData<Comment?>()
        private set

    fun toggleModalComment(showModal: Boolean = true) {
        modalStateComment.value = showModal
    }

    fun toggleModalCommentReply(showModal: Boolean = true) {
        modalStateCommentReply.value = showModal
    }

    fun setSelectedComment(comment: Comment) {
        commentSelected.value = comment
    }

//    val state = MutableLiveData<MainScreenState>(MainScreenState.Loading)

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

    fun patchUpvote(
        token: String,
        patchUpvote: PatchUpvote,
        onUpvoteSuccess: (Destination, ProfileId) -> Unit
    ) {
        viewModelScope.launch {
            try {
                state.value = MainScreenState.Loading
                Log.d("SignUpViewModel", "Loading started")
                val response = patchUpvoteUseCase(
                    token = token,
                    patchUpvote = patchUpvote
                )
                Log.d("Upvotado", response.toString())
                onUpvoteSuccess(
                    AppDestination.ProfileEstablishment.route,
                    patchUpvote.idEstablishment.toString()
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