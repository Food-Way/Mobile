package com.example.foodway.presentation.profile.customer

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.foodway.R
import com.example.foodway.presentation.components.Indicator

@Composable
fun CardInfoUser(
    qtdComments: Int,
    qtdUpvotes: Int
) {
    Row(
        modifier = Modifier
            .border(1.dp, Color.LightGray, RoundedCornerShape(10.dp))
            .width(350.dp)
            .height(100.dp)
            .padding(10.dp),
        horizontalArrangement = Arrangement.SpaceAround,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Column(
            modifier = Modifier
                .width(120.dp)
                .height(80.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(text = stringResource(id = R.string.comments))
            Indicator(
                quantity = qtdComments,
                hasQuantity = true,
                icon = R.drawable.comment,
                description = R.string.comments,
                size = 20.dp,
                fontSize = 14,
                widthIndicator = 40.dp
            )
        }
        Column(
            modifier = Modifier
        ) {
            VerticalLine()
        }
        Column(
            modifier = Modifier
                .width(120.dp)
                .height(80.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(text = stringResource(id = R.string.upvotes))
            Indicator(
                quantity = qtdUpvotes,
                hasQuantity = true,
                icon = R.drawable.upvote,
                description = R.string.upvotes,
                size = 20.dp,
                fontSize = 14,
                widthIndicator = 35.dp
            )
        }
    }
}

//@Preview(showBackground = true)
//@Composable
//fun CardInfoUserPreview() {
//    CardInfoUser()
//}