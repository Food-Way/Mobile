package com.example.foodway.di

import org.koin.dsl.module

val appModule = module {
    includes(
        presentationModule,
        domainModule,
        dataModule
    )
}