package com.example.foodway.view.profileEstablishment

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.OutlinedCard
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.example.foodway.R
import com.example.foodway.view.components.Indicator
import com.example.foodway.view.components.RatingBar

@Composable
fun Comment(
    width: Dp,
    height: Dp,
    isChild: Boolean
) {
    OutlinedCard(
        colors = CardDefaults.cardColors(
            containerColor = colorResource(id = R.color.white)
        ),
        border = BorderStroke(1.dp, colorResource(id = R.color.light_gray)),
        modifier = Modifier
            .size(width, height)
            .padding(8.dp),
    ) {
        Column(
            modifier = Modifier
                .padding(8.dp)
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                ) {
//                    ProfileImage(35.dp)
                    Spacer(modifier = Modifier.width(8.dp))
                    Text(
                        text = "Samuel De Oliveira",
                        fontWeight = FontWeight.Bold,
                    )
                    Indicator(
                        quantity = 100,
                        hasQuantity = false,
                        icon = R.drawable.upvote,
                        description = R.string.upvotes
                    )
                    Indicator(
                        quantity = 100,
                        hasQuantity = false,
                        icon = R.drawable.comment,
                        description = R.string.comments
                    )
                }
            }
            if (!isChild) {
                RatingBar(
                    modifier = Modifier
                        .size(20.dp),
                    rating = 5.0,
                    onRatingChanged = {},
                    starsColor = Color.Yellow,
                    editable = false
                )
            }
        }
        Spacer(modifier = Modifier.height(8.dp))
        Row(
            modifier = Modifier
                .padding(8.dp)
        ) {
            Text(
                text = "A comida é boa, porém o cara cuspiu em mim",
                textAlign = TextAlign.Justify
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun CommentPreview() {
    Comment(width = 270.dp, height = 160.dp, isChild = false)
}