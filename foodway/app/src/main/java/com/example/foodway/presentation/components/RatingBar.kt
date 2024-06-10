package com.example.foodway.presentation.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.AccountBox
import androidx.compose.material.icons.rounded.Add
import androidx.compose.material.icons.rounded.Star
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.example.foodway.R
import kotlin.math.round
import kotlin.math.roundToLong

@Composable
fun RatingBar(
    modifier: Modifier = Modifier,
    rating: Double = 0.0,
    stars: Int = 5,
    onRatingChanged: (Double) -> Unit,
    starsColor: Color = Color.Yellow,
    textColor: Color = Color.Black,
    editable: Boolean = true,
    viewValue: Boolean = true,
    sizeStar: Int = 18
) {

    var isHalfStar = (rating % 1) != 0.0

    Row(
        horizontalArrangement = Arrangement.SpaceAround,
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier
    ) {
        if (viewValue) {
            Text(
                text = (round(rating * 10) / 10).toString().replace(".",","),
                color = textColor
            )
        }
        for (index in 1..stars) {
            Icon(
                painter =
                if (index <= rating) {
                    painterResource(id = R.drawable.star_filled)
                } else {
                    if (isHalfStar) {
                        isHalfStar = false
                        painterResource(id = R.drawable.star_filled)
                    } else {
                        painterResource(id = R.drawable.star_empty)
                    }
                },
                contentDescription = null,
                tint = starsColor,
                modifier = Modifier
                    .size(sizeStar.dp)
                    .then(if (editable) Modifier.clickable { onRatingChanged(index.toDouble()) } else Modifier)
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun RatingBarEditablePreview() {
    RatingBar(
        modifier = Modifier
            .size(20.dp),
        rating = 5.0,
        onRatingChanged = {},
        starsColor = Color.Yellow,
        editable = true
    )
}

@Preview(showBackground = true)
@Composable
fun RatingBarNotEditablePreview() {
    RatingBar(
        modifier = Modifier
            .size(20.dp),
        rating = 5.0,
        onRatingChanged = {}, starsColor = Color.Yellow,
        editable = false
    )
}