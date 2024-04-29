package com.example.foodway.di

import com.example.foodway.repository.CulinaryRepositoryImpl
import com.example.foodway.repository.ICulinaryRepository
import com.example.foodway.viewModel.SignUpViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {
    single<ICulinaryRepository> {
        CulinaryRepositoryImpl()
    }
    viewModel {
        SignUpViewModel(get())
    }
}