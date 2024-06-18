package com.example.foodway.presentation.profile.customer

import ErrorView
import LoadingBar
import android.util.Log
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.foodway.domain.profile.customer.model.ProfileCustomer
import com.example.foodway.presentation.MainScreenState
import com.example.foodway.presentation.components.RatingBar
import com.example.foodway.presentation.ui.theme.FoodwayTheme
import com.example.foodway.utils.Destination
import com.example.foodway.utils.ProfileId
import java.util.UUID

@Composable
fun ProfileCustomer(
    vm: ProfileCustomerViewModel,
    idCustomer: UUID,
    onNavigate: (Destination, ProfileId) -> Unit,
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
                        Log.d("Success", "Success state$profile")

                        WelcomeProfile(
                            name = profile.name,
                            level = profile.level,
                            xp = profile.xp,
                            photo = profile.profilePhoto
                        )
                        Column(
                            modifier = Modifier
                                .fillMaxWidth()
                        ) {
                            Row(
                                modifier = Modifier
                                    .padding(start = 37.dp)
                            ) {
                                RatingBar(
                                    modifier = Modifier.width(180.dp),
                                    rating = 5.0,
                                    onRatingChanged = {},
                                    starsColor = Color.Yellow,
                                    editable = false,
                                    viewValue = true,
                                    sizeStar = 25
                                )
                            }

                            Spacer(modifier = Modifier.height(25.dp))

                            Row(
                                modifier = Modifier.fillMaxWidth(),
                                horizontalArrangement = Arrangement.Center
                            ) {
                                CardInfoUser(
                                    qtdComments = profile.qtdComments,
                                    qtdUpvotes = profile.qtdUpvotes
                                )
                            }
                        }

                        Spacer(modifier = Modifier.height(15.dp))

                        Column {
                            if (profile.recentEstablishment != null) {
                                RecentCard(
                                    recents = profile.recentEstablishment,
                                    onNavigate = onNavigate
                                )
                            } else {
                                Text(
                                    text = "Nenhum estabelecimento recente encontrado.",
                                    modifier = Modifier.padding(16.dp)
                                )
                            }

                            Spacer(modifier = Modifier.height(15.dp))

                            if (profile.favoriteEstablishment != null) {
                                FavoriteCard(
                                    favorites = profile.favoriteEstablishment,
                                    onNavigate = onNavigate
                                )
                            } else {
                                Text(
                                    text = "Nenhum estabelecimento favorito encontrado.",
                                    modifier = Modifier.padding(16.dp)
                                )
                            }
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