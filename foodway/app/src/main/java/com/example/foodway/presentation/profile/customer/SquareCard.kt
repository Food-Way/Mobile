package com.example.foodway.presentation.profile.customer

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.foodway.R
import com.example.foodway.presentation.components.CoilImage
import com.example.foodway.presentation.navigation.AppDestination
import com.example.foodway.utils.Destination
import com.example.foodway.utils.ProfileId
import java.util.UUID

@Composable
fun SquareCard(
    idEstablishment: UUID,
    name: String,
    photo: String,
    onNavigate: (Destination, ProfileId) -> Unit
) {
    Card(
        modifier = Modifier
            .padding(4.dp)
            .size(110.dp)
    ) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .clickable {
                    onNavigate(
                        AppDestination.ProfileEstablishment.route,
                        idEstablishment.toString()
                    )
                }
        ) {
            CoilImage(
                photo = photo,
                description = name,
                modifier = Modifier.fillMaxSize()
            )
            Text(
                text = name,
                color = colorResource(id = R.color.white),
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .align(Alignment.BottomCenter)
                    .padding(8.dp)
                    .fillMaxWidth()
            )
        }
    }
}

//@Preview(showBackground = true)
//@Composable
//fun SquareCardPreview() {
//    SquareCard()
//}