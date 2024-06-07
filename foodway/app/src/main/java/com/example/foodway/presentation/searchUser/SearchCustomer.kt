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
import com.example.foodway.domain.model.UserType
import com.example.foodway.presentation.MainScreenState
import com.example.foodway.presentation.components.CardUser
import com.example.foodway.presentation.components.ListCardUser
import com.example.foodway.utils.Destination
import com.example.foodway.utils.ProfileId

@Composable
fun SearchCustomer(
    vm: SearchUserViewModel,
    onNavigateToCustomer: (Destination, ProfileId) -> Unit
) {
    val state by vm.state.observeAsState()

    Column {
        UserSearchComponent(
            vm = vm
        )
        when (state) {
            is MainScreenState.Loading -> {
                Log.d("loading", "loading state")
                LoadingBar(
                    loadingText = "Carregando Clientes..."
                )
                vm.getAllCustomers()
            }

            is MainScreenState.Error, null -> {
                val errorMessage = (state as MainScreenState.Error).message
                Log.d("Error", "Error state")
                ErrorView(message = errorMessage) {
                    vm.getAllCustomers()
                }
            }

            is MainScreenState.Success<*> -> {
                val customers = (state as MainScreenState.Success<List<Customer>>).data

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
                        Log.d("customers", customers.toString())

                        val topThree = customers.take(3)

                        topThree.forEach { customer ->
                            CardUser(
                                id = customer.idUser,
                                name = customer.name,
                                rate = customer.rate ?: 0.0,
                                photo = customer.profilePhoto ?: "",
                                typeUser = UserType.CLIENT,
                                onNavigateToProfile = onNavigateToCustomer
                            )
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
                        items(customers.drop(3)) { customer ->
                            ListCardUser(
                                id = customer.idUser,
                                photo = customer.profilePhoto ?: "",
                                name = customer.name,
                                rateStar = customer.rate ?: 0.0,
                                description = customer.bio ?: "Sem descrição",
                                qtdComment = customer.qtdComments ?: 0,
                                qtdUpVotes = customer.qtdUpvotes ?: 0,
                                typeUser = UserType.CLIENT,
                                onNavigateToProfile = onNavigateToCustomer
                            )
                        }
                    }
                }
            }
        }
    }
}
