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
import com.example.foodway.domain.model.Establishment
import com.example.foodway.domain.model.UserType
import com.example.foodway.presentation.MainScreenState
import com.example.foodway.presentation.components.CardUser
import com.example.foodway.presentation.components.ListCardUser
import com.example.foodway.utils.Destination
import com.example.foodway.utils.ProfileId

@Composable
fun SearchEstablishment(
    vm: SearchUserViewModel,
    onNavigateToEstablishment: (Destination, ProfileId) -> Unit,
) {
    val state by vm.state.observeAsState()

    Column {
        UserSearchComponent(
            vm = vm,
        )
        when (state) {
            is MainScreenState.Loading -> {
                Log.d("loading", "loading state")
                LoadingBar(
                    loadingText = "Carregando Estabelecimentos..."
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
                val establishments = (state as MainScreenState.Success<List<Establishment>>).data
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
                        val topThree = establishments.take(3)

                        topThree.forEach { establishment ->
                            CardUser(
                                id = establishment.idEstablishment,
                                name = establishment.name,
                                rate = establishment.rate ?: 0.0,
                                photo = establishment.profilePhoto ?: "",
                                typeUser = UserType.ESTABLISHMENT,
                                onNavigateToProfile = onNavigateToEstablishment
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
                        items(establishments.drop(3)) { establishment ->
                            ListCardUser(
                                id = establishment.idEstablishment,
                                photo = establishment.profilePhoto ?: "",
                                name = establishment.name,
                                rateStar = establishment.rate ?: 0.0,
                                description = establishment.description ?: "Sem descrição",
                                qtdComment = establishment.qtdComments ?: 0,
                                qtdUpVotes = establishment.qtdUpvotes ?: 0,
                                typeUser = UserType.ESTABLISHMENT,
                                onNavigateToProfile = onNavigateToEstablishment
                            )
                        }
                    }
                }
            }
        }
    }
}
