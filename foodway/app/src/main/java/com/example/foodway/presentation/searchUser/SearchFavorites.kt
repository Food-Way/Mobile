package com.example.foodway.presentation.searchUser

import ErrorView
import LoadingBar
import SearchUserViewModel
import UserSearchComponent
import android.util.Log
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.foodway.domain.model.UserType
import com.example.foodway.presentation.MainScreenState
import com.example.foodway.presentation.components.CardUser
import com.example.foodway.presentation.components.ListCardUser
import com.example.foodway.utils.Destination
import com.example.foodway.utils.PreferencesManager
import com.example.foodway.utils.ProfileId
import java.util.UUID

@Composable
fun SearchFavorites(
    vm: SearchUserViewModel,
    sharedPreferences: PreferencesManager,
    onNavigateToFavorite: (Destination, ProfileId) -> Unit
) {
    val state by vm.state.observeAsState()
    val favorites by vm.favorites.observeAsState(emptyList())

    Column {
        UserSearchComponent(
            vm = vm
        )
        when (state) {
            is MainScreenState.Loading -> {
                Log.d("loading", "loading state")
                LoadingBar(
                    loadingText = "Carregando Favoritos..."
                )
//                vm.getAllFavorites()
            }

            is MainScreenState.Error, null -> {
                val errorMessage = (state as? MainScreenState.Error)?.message ?: "Erro desconhecido"
                Log.d("Error", "Error state")
                ErrorView(message = errorMessage) {
//                    vm.getAllFavorites()
                }
            }

            is MainScreenState.Success<*> -> {
                Column {
                    Text(
                        modifier = Modifier
                            .padding(0.dp, 13.dp),
                        text = "Amo demais ❤️",
                        fontWeight = FontWeight.Bold,
                        fontSize = 18.sp
                    )
                    Row(
                        horizontalArrangement = Arrangement.SpaceBetween,
                        modifier = Modifier
                            .fillMaxWidth()
                    ) {
                        Log.d("favorites", favorites.toString())

                        val topThree = favorites.take(3)

                        if (favorites.isEmpty()) {
//                            vm.getAllFavorites()
                        } else {
                            topThree.forEach { favorite ->
                                CardUser(
                                    id = UUID.fromString(favorite.idEstablishment),
                                    name = favorite.name,
                                    rate = favorite.generalRate ?: 0.0,
                                    photo = favorite.photo ?: "",
                                    typeUser = UserType.ESTABLISHMENT,
                                    onNavigateToProfile = onNavigateToFavorite
                                )
                            }
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
                        text = "Outros favoritos ✨",
                        fontWeight = FontWeight.Bold,
                        fontSize = 18.sp
                    )
                    LazyColumn(
                        modifier = Modifier
                            .height(300.dp),
                        verticalArrangement = Arrangement.SpaceAround
                    ) {
                        items(favorites.drop(3)) { favorite ->
                            ListCardUser(
                                id = UUID.fromString(favorite.idEstablishment),
                                photo = favorite.photo ?: "",
                                name = favorite.name,
                                rateStar = favorite.generalRate ?: 0.0,
                                description = favorite.bio ?: "Sem descrição",
                                qtdComment = favorite.qtdComments ?: 0,
                                qtdUpVotes = favorite.upvote ?: 0,
                                typeUser = UserType.ESTABLISHMENT,
                                onNavigateToProfile = onNavigateToFavorite,
                                isFavorite = favorite.isFavorite,
                                vm = vm,
                                sharedPreferences = sharedPreferences,
                                haveFavorite = true
                            )
                        }
                    }
                }
            }
        }
    }
}