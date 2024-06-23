package com.example.foodway.domain.edit.usecase

import com.example.foodway.domain.edit.repository.IUploadFileRepository
import okhttp3.MultipartBody

class PostImageUseCase(
    private val uploadFileRepository: IUploadFileRepository
) {
    suspend operator fun invoke(
        formData: List<MultipartBody.Part>,
        token: String
    ): String {
        try {
            val response = uploadFileRepository.upload(
                formData = formData,
                token = token
            )
           return response
        } catch (e: Exception) {
            throw e
        }
    }
}