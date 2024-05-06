package com.example.foodway.view.profileCustomer

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

@Composable
fun FavoriteCard(
//    favorites: List<EstablishmentCard>
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
//            repeat(3) {
//                SquareCard(
//                    name = favorites.get(it).establishmentName,
//                    photo = favorites.get(it).photo
//                )
//            }
        }
    }
}

//@Preview(showBackground = true)
//@Composable
//fun FavoriteCardPreview() {
//    FavoriteCard()
//}