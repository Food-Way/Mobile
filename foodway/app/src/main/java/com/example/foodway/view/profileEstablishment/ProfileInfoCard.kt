package com.example.foodway.view.profileEstablishment

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.OutlinedCard
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.zIndex
import com.example.foodway.R
import com.example.foodway.view.components.ButtonGeneric
import com.example.foodway.view.components.CoilImage
import com.example.foodway.view.components.Indicator
import com.example.foodway.view.components.RatingBar

@Composable
fun ProfileInfoCard(
    modifier: Modifier,
    name: String,
    headerImage: String,
    culinary: String,
    rate: Double,
    description: String,
    qtdComments: Int,
    qtdUpvotes: Int
) {
    Box(
        contentAlignment = Alignment.Center
    ) {
        CoilImage(
            photo = headerImage,
            description = "Foto de capa de $name",
            modifier = Modifier
                .fillMaxWidth()
                .height(290.dp)
        )

        OutlinedCard(
            modifier = Modifier
                .width(240.dp)
                .zIndex(1f)
                .height(220.dp)
        ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp)
            ) {
                Text(
                    text = name,
                    fontWeight = FontWeight.Bold,
                    fontSize = 16.sp
                )
                Text(
                    text = "Culinária $culinary",
                    fontWeight = FontWeight.Normal,
                    fontSize = 10.sp
                )
                RatingBar(
                    modifier = Modifier
                        .size(20.dp),
                    rating = rate,
                    onRatingChanged = {},
                    starsColor = Color.Yellow,
                    editable = false
                )
                Text(
                    text = description,
                )
                Row(
                    horizontalArrangement = Arrangement.Start
                ) {
//                    CulinaryCard(
//                        culinary = culinary
//                    )
                }
                Spacer(
                    modifier = Modifier.height(40.dp)
                )
                Row(
                    modifier = Modifier
                        .fillMaxSize()
                        .align(Alignment.CenterHorizontally),
                    horizontalArrangement = Arrangement.SpaceAround,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Indicator(
                        quantity = qtdComments,
                        hasQuantity = true,
                        icon = R.drawable.comment,
                        description = R.string.comments
                    )
                    ButtonGeneric(
                        text = stringResource(id = R.string.menu),
                        modifier = Modifier
                            .width(75.dp)
                            .height(15.dp),
                        isPrimary = true,
                        onClick = {}
                    )
                    Indicator(
                        quantity = qtdUpvotes,
                        hasQuantity = true,
                        icon = R.drawable.upvote,
                        description = R.string.upvotes
                    )
                }
            }
        }
    }
}

//@Preview(showBackground = true)
//@Composable
//fun ProfileInfoCardPreview() {
//    ProfileInfoCard(modifier = Modifier)
//}