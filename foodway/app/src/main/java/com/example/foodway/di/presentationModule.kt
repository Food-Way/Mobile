package com.example.foodway.di

import com.example.foodway.presentation.edit.EditViewModel
import com.example.foodway.presentation.establishmentMenu.MenuEstablishmentViewModel
import com.example.foodway.presentation.profile.customer.ProfileCustomerViewModel
import com.example.foodway.presentation.profile.establishment.CommentViewModel
import com.example.foodway.presentation.profile.establishment.ProfileEstablishmentViewModel
import com.example.foodway.presentation.searchUser.SearchUserViewModel
import com.example.foodway.presentation.signIn.SignInViewModel
import com.example.foodway.presentation.signUp.SignUpViewModel
import org.koin.dsl.module

val presentationModule = module {

    factory<SignUpViewModel> {
        SignUpViewModel(
            createUserUseCase = get(),
            getAllCulinariesUseCase = get()
        )
    }

    factory<SearchUserViewModel> {
        SearchUserViewModel(
            getCustomerUseCase = get(),
            getFavoriteUseCase = get(),
            getEstablishmentUseCase = get(),
            context = get()
        )
    }

    factory<EditViewModel> {
        EditViewModel(
            updateAccountUseCase = get(),
            updateProfileUseCase = get(),
            getEstablishmentAccountUseCase = get(),
            getCustomerAccountUseCase = get(),
            postImageUseCase = get()
        )
    }

    single<MenuEstablishmentViewModel> {
        MenuEstablishmentViewModel(
            getEstablishmentMenuUseCase = get()
        )
    }

    single<ProfileCustomerViewModel> {
        ProfileCustomerViewModel(
            getCustomerProfileUseCase = get()
        )
    }

    single<ProfileEstablishmentViewModel> {
        ProfileEstablishmentViewModel(
            getEstablishmentProfileUseCase = get(),
        )
    }

    single<CommentViewModel> {
        CommentViewModel(
            postCommentUseCase = get()
        )
    }

    single<SignInViewModel> {
        SignInViewModel(
            getUserUseCase = get(),
            context = get()
        )
    }
}