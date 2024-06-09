package com.example.foodway.presentation.profile.establishment

import androidx.lifecycle.ViewModel
import com.example.foodway.domain.profile.establishment.usecase.PostCommentUseCase

class CommentViewModel(
    private val postCommentUseCase: PostCommentUseCase
) : ViewModel() {

}