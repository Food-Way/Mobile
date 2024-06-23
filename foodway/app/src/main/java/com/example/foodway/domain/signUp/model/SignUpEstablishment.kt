package com.example.foodway.domain.signUp.model

import com.example.foodway.domain.model.Culinary

data class SignUpEstablishment(
    val fantasyName: String,
    val responsible: String,
    val email: String,
    val password: String,
    val cnpj: Int,
    val cep: Int,
    val number: String,
    val categories: List<Culinary>,
)