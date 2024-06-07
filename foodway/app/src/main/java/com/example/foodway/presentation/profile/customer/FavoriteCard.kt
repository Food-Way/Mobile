package com.example.foodway.presentation.profile.customer

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.foodway.R
import com.example.foodway.domain.model.EstablishmentCard
import com.example.foodway.utils.Destination
import com.example.foodway.utils.ProfileId

@Composable
fun FavoriteCard(
    favorites: List<EstablishmentCard>,
    onNavigate: (Destination, ProfileId) -> Unit
) {
    Column(
        modifier = Modifier.padding(16.dp)
    ) {
        Text(
            text = stringResource(id = R.string.favorites),
            modifier = Modifier.padding(bottom = 8.dp),
            fontWeight = FontWeight.Bold
        )
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            repeat(3) {
                SquareCard(
                    idEstablishment = favorites[it].idEstablishment,
                    name = favorites[it].establishmentName,
                    photo = favorites[it].photo ?: "https://foodway.s3.amazonaws.com/public-images/establishment.webp",
                    onNavigate = onNavigate
                )
            }
        }
    }
}

//@Preview(showBackground = true)
//@Composable
//fun FavoriteCardPreview() {
//    FavoriteCard()
//}