package com.example.foodway.domain.edit.usecase

import com.example.foodway.domain.edit.repository.IUploadFileRepository
import okhttp3.MultipartBody

class PostImageUseCase(
    private val uploadFileRepository: IUploadFileRepository
) {
    suspend operator fun invoke(
        formData: List<MultipartBody.Part>,
        token: String
    ) {
        try {
            val response = uploadFileRepository.upload(
                formData = formData,
                token = token
            )
            if (response.isSuccessful) {
                response.body() ?: throw Exception("Response body is null")
            } else {
                throw Exception(response.errorBody()?.string() ?: "Unknown error")
            }
        } catch (e: Exception) {
            throw e
        }
    }
}