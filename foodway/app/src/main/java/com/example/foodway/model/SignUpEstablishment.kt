package com.example.foodway.model

data class SignUpEstablishment(
    val firstStep: FirstStep,
    val secondStep: SecondStep,
    val thirdStep: ThirdStep
) {
    data class FirstStep(
        val fantasyName: String,
        val responsible: String,
        val email: String,
        val password: String,
    )

    data class SecondStep(
        val cnpj: Int,
        val cep: Int,
        val number: String,
    )

    data class ThirdStep(
        val categories: List<Category>
    )
}