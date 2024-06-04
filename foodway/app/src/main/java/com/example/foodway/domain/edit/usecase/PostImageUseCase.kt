package com.example.foodway.domain.edit.usecase

import com.example.foodway.domain.edit.repository.IUploadFileRepository
import okhttp3.MultipartBody

class PostImageUseCase(
    private val uploadFileRepository: IUploadFileRepository
) {
    suspend operator fun invoke(
        image: MultipartBody.Part,
    ) {
        try {
            val response = uploadFileRepository.upload(image = image)
            if (response.isSuccessful) {
                return response.body() ?: throw Exception("Response body is null")
            } else {
                throw Exception(response.errorBody().toString())
            }
        } catch (e: Exception) {
            throw e
        }
    }
}