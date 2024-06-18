package com.example.foodway.presentation.searchUser

import SearchUserViewModel
import TabScreen
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.foodway.R
import com.example.foodway.presentation.components.CoilImage
import com.example.foodway.presentation.ui.theme.FoodwayTheme
import com.example.foodway.utils.Destination
import com.example.foodway.utils.PreferencesManager
import com.example.foodway.utils.ProfileId
import com.google.accompanist.pager.ExperimentalPagerApi

@OptIn(ExperimentalPagerApi::class)
@Composable
fun SearchUser(
    vm: SearchUserViewModel,
    sharedPreferences: PreferencesManager,
    onNavigateToEstablishment: (Destination, ProfileId) -> Unit,
    onNavigateToCustomer: (Destination, ProfileId) -> Unit,
    onNavigateToFavorites: (Destination, ProfileId) -> Unit
) {

    FoodwayTheme {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Row(
                    modifier = Modifier
                        .width(380.dp)
                        .padding(20.dp),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Column {
                        Text(
                            text = "Pesquisa de usuários",
                            fontWeight = FontWeight.Bold,
                            fontSize = 18.sp
                        )
                        Text(
                            text = "Explore, conheça e favorite",
                            fontSize = 14.sp
                        )
                    }

                    var photo = sharedPreferences.getSavedData("photo", "")

                    if (photo.isNotEmpty()) {
                        CoilImage(
                            photo = photo,
                            description = stringResource(id = R.string.image_profile_desc),
                            modifier = Modifier
                                .size(80.dp)
                                .clip(CircleShape)
                                .border(
                                    2.dp,
                                    colorResource(id = R.color.light_gray),
                                    RoundedCornerShape(50.dp)
                                ),
                            type = "profile"
                        )
                    } else {
                        Image(
                            painter = painterResource(id = R.drawable.goku),
                            contentDescription = stringResource(id = R.string.image_profile_desc),
                            modifier = Modifier
                                .size(75.dp)
                                .clip(CircleShape)
                                .border(
                                    2.dp,
                                    colorResource(id = R.color.light_gray),
                                    RoundedCornerShape(50.dp)
                                ),
                            contentScale = ContentScale.Fit
                        )
                    }
                }
                TabScreen(
                    vm = vm,
                    sharedPreferences = sharedPreferences,
                    onNavigateToEstablishment = onNavigateToEstablishment,
                    onNavigateToCustomer = onNavigateToCustomer,
                    onNavigateToFavorites = onNavigateToFavorites,

                )
//                NavBarComponent()
            }
        }
    }
}