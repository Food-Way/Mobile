package com.example.foodway.view.profileCustomer

import ErrorView
import LoadingBar
import android.util.Log
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import com.example.foodway.model.ProfileCustomer
import com.example.foodway.ui.theme.FoodwayTheme
import com.example.foodway.viewModel.MainScreenState
import com.example.foodway.viewModel.ProfileCustomerViewModel
import java.util.UUID

@Composable
fun ProfileCustomer(
    vm: ProfileCustomerViewModel,
    idCustomer: UUID,
    onNavigate: () -> Unit,
) {
    val state by vm.state.observeAsState()
    FoodwayTheme {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
            Column(
                verticalArrangement = Arrangement.SpaceBetween
            ) {

                when (state) {
                    is MainScreenState.Loading -> {
                        Log.d("loading", "loading state")
                        LoadingBar(
                            loadingText = "Carregando Perfil..."
                        )
                        vm.getCustomerProfile(idCustomer = idCustomer)
                    }

                    is MainScreenState.Error, null -> {
                        val errorMessage = (state as MainScreenState.Error).message
                        Log.d("Error", "Error state")
                        ErrorView(message = errorMessage) {
                            vm.getCustomerProfile(idCustomer = idCustomer)
                        }
                    }

                    is MainScreenState.Success<*> -> {
                        val profile = (state as MainScreenState.Success<ProfileCustomer>).data
                        Log.d("Success", "Success state")

                        WelcomeProfile(
                            name = profile.name,
                            level = profile.level,
                            xp = profile.xp,
                            photo = profile.profilePhoto
                        )
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.Center
                        ) {
                            CardInfoUser(
                                qtdComments = profile.qtdComments,
                                qtdUpvotes = profile.qtdUpvotes
                            )
                        }
                        Column {
                            RecentCard()
                            FavoriteCard(
//                                favorites = profile.favoriteEstablishment
                            )
                        }
//                        NavBarComponent()
                    }
                }
            }
        }
    }
}

//@Preview(showBackground = true)
//@Composable
//fun DefaultPreview() {
//    ProfileCustomerScreen()
//}