package com.example.foodway.domain.searchUser.model

import com.example.foodway.model.Customer
import com.example.foodway.model.Establishment

data class SearchUser(
    val customers: List<Customer>,
    val establishments: List<Establishment>
)
