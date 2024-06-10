package com.example.foodway.presentation.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.foodway.R

@Composable
fun Indicator(
    quantity: Int,
    hasQuantity: Boolean,
    icon: Int,
    description: Int,
    size: Dp,
    fontSize: Int,
    widthIndicator: Dp
) {
    Row(
        modifier = Modifier.width(widthIndicator),
        horizontalArrangement = Arrangement.SpaceEvenly,
        verticalAlignment = Alignment.CenterVertically
    ) {

        if (hasQuantity) {
            Text(
                text = quantity.toString(),
                fontSize = fontSize.sp
            )
        }

        Image(
            painter = painterResource(icon),
            contentDescription = stringResource(description),
            modifier = Modifier
                .size(size),
            contentScale = ContentScale.Fit
        )
    }
}

@Preview
@Composable
fun CommentIndicatorPreview() {
    Indicator(
        quantity = 100,
        hasQuantity = true,
        icon = R.drawable.comment,
        description = R.string.comments,
        size = 10.dp,
        fontSize = 10,
        widthIndicator = 30.dp
    )
}

@Preview
@Composable
fun UpvotesIndicatorPreview() {
    Indicator(
        quantity = 100,
        hasQuantity = true,
        icon = R.drawable.upvote,
        description = R.string.upvotes,
        size = 10.dp,
        fontSize = 10,
        widthIndicator = 30.dp
    )
}
