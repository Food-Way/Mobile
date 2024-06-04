package com.example.foodway.presentation.searchUser

import ErrorView
import LoadingBar
import UserSearchComponent
import android.util.Log
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.foodway.domain.model.Customer
import com.example.foodway.presentation.MainScreenState
import com.example.foodway.presentation.components.CardUser
import com.example.foodway.presentation.components.ListCardUser


@Composable
fun SearchCustomer(
    vm: SearchUserViewModel
) {
    val state by vm.state.observeAsState()
    var users = mutableListOf("", "", "", "")

    Column {
        UserSearchComponent() {}
        when (state) {
            is MainScreenState.Loading -> {
                Log.d("loading", "loading state")
                LoadingBar(
                    loadingText = "Carregando Clientes..."
                )
                vm.getAllEstablishments()
            }

            is MainScreenState.Error, null -> {
                val errorMessage = (state as MainScreenState.Error).message
                Log.d("Error", "Error state")
                ErrorView(message = errorMessage) {
                    vm.getAllEstablishments()
                }
            }

            is MainScreenState.Success<*> -> {
                val customers = (state as MainScreenState.Success<List<Customer>>).data
                Log.d("Success", "Success state")
                Column {
                    Text(
                        modifier = Modifier
                            .padding(0.dp, 13.dp),
                        text = "Populares ⭐",
                        fontWeight = FontWeight.Bold,
                        fontSize = 18.sp
                    )
                    Row(
                        horizontalArrangement = Arrangement.SpaceBetween,
                        modifier = Modifier
                            .fillMaxWidth()
                    ) {
                        var topTree = listOf('1', '2', '3')

                        topTree.forEach { user ->
                            CardUser()
                        }
                    }
                }
                Column(
                    modifier = Modifier
                        .padding(top = 10.dp),
                ) {
                    Text(
                        modifier = Modifier
                            .padding(0.dp, 13.dp),
                        text = "Você também vai gostar 😋",
                        fontWeight = FontWeight.Bold,
                        fontSize = 18.sp
                    )
                    LazyColumn(
                        verticalArrangement = Arrangement.SpaceAround
                    ) {
                        items(customers) { customer ->
                            ListCardUser(
                                photo = "",
                                name = customer.name,
                                rateStar = customer.rate,
                                description = "customer.bio",
                                qtdComment = customer.qtdComments,
                                qtdUpVotes = customer.qtdUpvotes
                            )
                        }
                    }
                }
            }
        }
    }
}