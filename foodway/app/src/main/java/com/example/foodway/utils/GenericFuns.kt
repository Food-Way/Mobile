package com.example.foodway.utils

fun validateField(field: Any?, fieldName: String) {
    if (field == null || (field is String && field.isBlank())) {
        throw IllegalArgumentException("$fieldName cannot be empty")
    }
}