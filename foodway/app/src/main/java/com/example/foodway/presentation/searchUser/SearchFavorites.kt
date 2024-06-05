package com.example.foodway.presentation.searchUser

import ErrorView
import LoadingBar
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
import com.example.foodway.domain.model.Establishment
import com.example.foodway.presentation.MainScreenState
import com.example.foodway.presentation.components.CardUser
import com.example.foodway.presentation.components.ListCardUser


@Composable
fun SearchFavorites(
    vm: SearchUserViewModel
) {
    val state by vm.state.observeAsState()

    when (state) {
        is MainScreenState.Loading -> {
            Log.d("loading", "loading state")
            LoadingBar(
                loadingText = "Carregando Favoritos..."
            )
            vm.getAllFavorites()
        }

        is MainScreenState.Error, null -> {
            val errorMessage = (state as MainScreenState.Error).message
            Log.d("Error", "Error state")
            ErrorView(message = errorMessage) {
                vm.getAllFavorites()
            }
        }

        is MainScreenState.Success<*> -> {
            val favorites = (state as MainScreenState.Success<List<Establishment>>).data
            Log.d("Success", "Success state")

            Column {
                UserSearchComponent() {}
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
                        val topThree = favorites.slice(0..2)

                        repeat(3) {
                            CardUser(
                                name = topThree[it].name,
                                rate = topThree[it].rate,
                                photo = "topThree[it].profilePhoto"
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
                        text = "Outros favoritos ✨",
                        fontWeight = FontWeight.Bold,
                        fontSize = 18.sp
                    )
                    LazyColumn(
                        modifier = Modifier
                            .height(300.dp),
                        verticalArrangement = Arrangement.SpaceAround
                    ) {
                        items(favorites) { favorite ->
                            ListCardUser(
                                photo ="",
                                name = favorite.name,
                                rateStar = favorite.rate,
                                description = "favorite.description",
                                qtdComment = favorite.qtdComments,
                                qtdUpVotes = favorite.qtdUpvotes
                            )
                        }
                    }
                }
            }
        }
    }
}
//
//    @Preview
//    @Composable
//    fun SearchFavoritesPreview() {
//        SearchFavorites()
//    }