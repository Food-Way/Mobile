package com.example.foodway.di

import android.content.Context
import android.content.SharedPreferences
import org.koin.dsl.module

val appModule = module {

    single<SharedPreferences> {
        get<Context>().getSharedPreferences("user_preferences", Context.MODE_PRIVATE)
    }

    includes(
        presentationModule,
        domainModule,
        dataModule
    )
}