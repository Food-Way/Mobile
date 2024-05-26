package com.example.foodway.di

import com.example.foodway.presentation.establishmentMenu.MenuEstablishmentViewModel
import com.example.foodway.presentation.profile.customer.ProfileCustomerViewModel
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
            sharedPreferences = get()
        )
    }

    single<MenuEstablishmentViewModel> {
        MenuEstablishmentViewModel(get())
    }

    single<ProfileCustomerViewModel> {
        ProfileCustomerViewModel(get())
    }

    single<ProfileEstablishmentViewModel> {
        ProfileEstablishmentViewModel(get())
    }

    single<SignInViewModel> {
        SignInViewModel(get(), get())
    }
}