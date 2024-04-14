package com.example.foodway.model

data class SignUpEstablishment(
    val fantasyName: String,
    val responsible: String,
    val email: String,
    val password: String,
    val cnpj: Int,
    val cep: Int,
    val number: String,
    val categories: List<Culinary>
){
    val typeUser: String get() = "ESTABLISHMENT"
}