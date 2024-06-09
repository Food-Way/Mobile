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
import com.example.foodway.domain.edit.establishment.repository.GetEstablishmentAccountUseCase
import com.example.foodway.domain.edit.usecase.PostImageUseCase
import com.example.foodway.domain.edit.usecase.UpdateAccountUseCase
import com.example.foodway.domain.edit.usecase.UpdateProfileUseCase
import com.example.foodway.domain.model.UserType
import com.example.foodway.presentation.MainScreenState
import com.example.foodway.presentation.navigation.AppDestination
import com.example.foodway.utils.Destination
import com.example.foodway.utils.PreferencesManager
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
    private val getEstablishmentAccountUseCase: GetEstablishmentAccountUseCase,
    private val postImageUseCase: PostImageUseCase
) : ViewModel() {
    val state = MutableLiveData<MainScreenState>(MainScreenState.Loading)

    fun editAccount(
        idUser: UUID,
        editCustomerAccount: EditCustomerAccount? = null,
        editEstablishmentAccount: EditEstablishmentAccount? = null,
        sharedPreferences: PreferencesManager,
        onNavigateSuccess: () -> Unit = {},
    ) {
        viewModelScope.launch {
            try {
                state.value = MainScreenState.Loading

                Log.d("teste", "editAccount: $editCustomerAccount")
                Log.d("teste", "editAccount: $idUser")

                val response = when {
                    editCustomerAccount != null -> updateAccountUseCase(
                        idCustomer = idUser,
                        editCustomerAccount = editCustomerAccount,
                        token = sharedPreferences.getSavedData("token", "")
                    )

                    editEstablishmentAccount != null -> updateAccountUseCase(
                        idEstablishment = idUser,
                        editEstablishmentAccount = editEstablishmentAccount,
                        token = sharedPreferences.getSavedData("token", "")
                    )

                    else -> throw IllegalArgumentException("No edit account data provided")
                }

                Log.d("Samuel", "Loading success: $response")
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
        sharedPreferences: PreferencesManager,
    ) {
        viewModelScope.launch {
            try {
                state.value = MainScreenState.Loading

                Log.i("teste", "getProfile: $idUser")
                Log.i("teste", "getProfile: $editEstablishmentProfile")

                val response = when {
                    editCustomerProfile != null -> updateProfileUseCase(
                        idCustomer = idUser,
                        editCustomerProfile = editCustomerProfile
                    )


                    editEstablishmentProfile != null -> updateProfileUseCase(
                        idEstablishment = idUser,
                        editEstablishmentProfile = editEstablishmentProfile,
                        token = sharedPreferences.getSavedData("token", "")
                    )

                    else -> throw IllegalArgumentException("No edit account data provided")
                }

                onNavigateSuccessEdit()

            } catch (e: HttpException) {
                Log.e("SignUpViewModel", "HTTP Exception: ${e.message()}")
                Log.e("SignUpViewModel", "Status code: ${e.code()}")
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
                    UserType.ESTABLISHMENT -> getEstablishmentAccountUseCase(idUser)
                    UserType.CLIENT -> getCustomerAccountUseCase(idUser)
                    else -> {
                        Log.e("User Profile", "Type not found")
                    }
                }

                state.value = MainScreenState.Success(data = response)

                Log.d("EditViewModel", "Loading success: $response")

            } catch (e: HttpException) {
                Log.e("EditViewModel", "HTTP Exception: ${e.message()}")
                val message = when (e.code()) {
                    404 -> "Perfil não encontrado"
                    400 -> "Parâmetros incorretos"
                    else -> "Erro desconhecido"
                }
                state.value = MainScreenState.Error(message)
            } catch (e: Exception) {
                Log.e("EditViewModel", "Exception: ${e.message}")
                state.value = MainScreenState.Error(
                    e.message ?: "Erro desconhecido"
                )
            }
        }
    }

    fun editImage(
        uri: String,
        context: Context,
        sharedPreferences: PreferencesManager,
        onNavigateSuccessEditImage: (Destination) -> Unit,
        typeUser: String
    ) {
        viewModelScope.launch {
            try {
                state.value = MainScreenState.Loading
                val filePath = getPathFromUri(context, uri.toUri())
                val file = File(filePath)

                val fileRequestBody = file.asRequestBody("image/*".toMediaTypeOrNull())
                val filePart = MultipartBody.Part.createFormData("file", file.name, fileRequestBody)
                val pathPart = MultipartBody.Part.createFormData("path", "user-images")
                val userTypePart = MultipartBody.Part.createFormData("typeUser", typeUser)
                val idUserPart = MultipartBody.Part.createFormData(
                    "idUser",
                    sharedPreferences.getSavedData("id", "")
                )

                val formData = listOf(filePart, pathPart, userTypePart, idUserPart)
                Log.d("SignUpViewModel", "Loading success: $formData")

                val response = postImageUseCase(
                    formData = formData,
                    token = sharedPreferences.getSavedData("token", "")
                )
                //toast de sucesso ?
                when (typeUser) {
                    "CLIENT" -> {
                        onNavigateSuccessEditImage(
                            AppDestination.EditCustomerProfile.route
                        )

                    }
                    "ESTABLISHMENT" -> {
                        onNavigateSuccessEditImage(
                            AppDestination.EditEstablishmentProfile.route
                        )
                    }
                }
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