package com.example.foodway.di

import SearchUserViewModel
import com.example.foodway.presentation.edit.EditViewModel
import com.example.foodway.presentation.establishmentMenu.MenuEstablishmentViewModel
import com.example.foodway.presentation.profile.customer.ProfileCustomerViewModel
import com.example.foodway.presentation.profile.establishment.ProfileEstablishmentViewModel
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
//            getFavoriteUseCase = get(),
            getEstablishmentUseCase = get(),
            patchFavoriteUseCase = get(),
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

    factory<MenuEstablishmentViewModel> {
        MenuEstablishmentViewModel(
            getEstablishmentMenuUseCase = get()
        )
    }

    single<ProfileCustomerViewModel> {
        ProfileCustomerViewModel(
            getCustomerProfileUseCase = get()
        )
    }

    factory<ProfileEstablishmentViewModel> {
        ProfileEstablishmentViewModel(
            getEstablishmentProfileUseCase = get(),
            postCommentUseCase = get(),
            patchUpvoteUseCase = get(),
            postRateUseCase = get()
        )
    }

    single<SignInViewModel> {
        SignInViewModel(
            getUserUseCase = get(),
            context = get()
        )
    }
}