package com.example.foodway.presentation.edit

import android.content.Context
import android.net.Uri
import android.util.Log
import androidx.core.net.toUri
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.foodway.domain.edit.customer.model.EditCustomerAccount
import com.example.foodway.domain.edit.customer.model.EditCustomerProfile
import com.example.foodway.domain.edit.customer.usecase.GetCustomerAccountUseCase
import com.example.foodway.domain.edit.establishment.model.EditEstablishmentAccount
import com.example.foodway.domain.edit.establishment.model.EditEstablishmentProfile
import com.example.foodway.domain.edit.usecase.PostImageUseCase
import com.example.foodway.domain.edit.usecase.UpdateAccountUseCase
import com.example.foodway.domain.edit.usecase.UpdateProfileUseCase
import com.example.foodway.domain.model.UserType
import com.example.foodway.domain.profile.establishment.usecase.GetEstablishmentProfileUseCase
import com.example.foodway.presentation.MainScreenState
import kotlinx.coroutines.launch
import okhttp3.MediaType.Companion.toMediaTypeOrNull
import okhttp3.MultipartBody
import okhttp3.RequestBody.Companion.asRequestBody
import retrofit2.HttpException
import java.io.File
import java.util.UUID

class EditViewModel(
    private val updateAccountUseCase: UpdateAccountUseCase,
    private val updateProfileUseCase: UpdateProfileUseCase,
    private val getCustomerAccountUseCase: GetCustomerAccountUseCase,
    private val getEstablishmentProfileUseCase: GetEstablishmentProfileUseCase,
    private val postImageUseCase: PostImageUseCase
) : ViewModel() {
    val state = MutableLiveData<MainScreenState>(MainScreenState.Loading)

    fun editAccount(
        idUser: UUID,
        editCustomerAccount: EditCustomerAccount? = null,
        editEstablishmentAccount: EditEstablishmentAccount? = null,
        onNavigateSuccess: () -> Unit = {},
    ) {
        viewModelScope.launch {
            try {
                state.value = MainScreenState.Loading

                val response = when {
                    editCustomerAccount != null -> updateAccountUseCase(
                        idCustomer = idUser,
                        editCustomerAccount = editCustomerAccount
                    )

                    editEstablishmentAccount != null -> updateAccountUseCase(
                        idEstablishment = idUser,
                        editEstablishmentAccount = editEstablishmentAccount
                    )

                    else -> throw IllegalArgumentException("No edit account data provided")
                }

                Log.d("SignUpViewModel", "Loading success: $response")
                onNavigateSuccess()

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

    fun editProfile(
        idUser: UUID,
        editCustomerProfile: EditCustomerProfile? = null,
        editEstablishmentProfile: EditEstablishmentProfile? = null,
        onNavigateSuccessEdit: () -> Unit = {},
    ) {
        viewModelScope.launch {
            try {
                state.value = MainScreenState.Loading

                val response = when {
                    editCustomerProfile != null -> updateProfileUseCase(
                        idCustomer = idUser,
                        editCustomerProfile = editCustomerProfile
                    )

                    editEstablishmentProfile != null -> updateProfileUseCase(
                        idEstablishment = idUser,
                        editEstablishmentProfile = editEstablishmentProfile
                    )

                    else -> throw IllegalArgumentException("No edit account data provided")
                }

                Log.d("SignUpViewModel", "Loading success: $response")
                onNavigateSuccessEdit()

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

    fun getProfile(
        idUser: UUID,
        type: UserType
    ) {
        viewModelScope.launch {
            try {
                state.value = MainScreenState.Loading

                val response = when (type) {
                    UserType.CLIENT -> getCustomerAccountUseCase(idUser)
                    UserType.ESTABLISHMENT -> getEstablishmentProfileUseCase(idUser)
                }

                state.value = MainScreenState.Success(data = response)

                Log.d("SignUpViewModel", "Loading success: $response")

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

    fun editImage(
        uri: String,
        context: Context,
        onNavigateToLogin: () -> Unit = {}
    ) {
        viewModelScope.launch {
            try {
                state.value = MainScreenState.Loading
                val filePath = getPathFromUri(context, uri.toUri())
                val file = File(filePath)

                val requestBody = file.asRequestBody("image/*".toMediaTypeOrNull())
                val imagePart = MultipartBody.Part.createFormData("file", file.name, requestBody)
                val pathPart = MultipartBody.Part.createFormData("path", "user-images")
                val typePart = MultipartBody.Part.createFormData("type", UserType.CLIENT.name)
                Log.d("SignUpViewModel", "Loading success: $imagePart")

                val response = postImageUseCase(imagePart, pathPart, typePart)
                onNavigateToLogin()
            } catch (e: Exception) {
                val message = e.message ?: "Algo deu errado. Por favor, contate o suporte."
                state.value = MainScreenState.Error(message)
            }
        }
    }

    private fun getPathFromUri(context: Context, uri: Uri): String? {
        try {
            val projection = arrayOf("_data")
            val cursor = context.contentResolver.query(uri, projection, null, null, null)

            return cursor?.use {
                val columnIndex = it.getColumnIndexOrThrow("_data")
                it.moveToFirst()
                it.getString(columnIndex)
            }
        } catch (e: Exception) {
            return e.message!!
        }
    }

}