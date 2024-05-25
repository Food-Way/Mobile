package com.example.foodway.presentation.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun RatingBar(
    modifier: Modifier = Modifier,
    rating: Double = 0.0,
    stars: Int = 5,
    onRatingChanged: (Double) -> Unit,
    starsColor: Color = Color.Yellow,
    editable: Boolean = true,
    viewValue: Boolean = true
) {

    var isHalfStar = (rating % 1) != 0.0

    Row(
        verticalAlignment = Alignment.CenterVertically
    ) {
        if (viewValue) {
            Text(text = rating.toString().replace(".",","))
        }
        for (index in 1..stars) {
            Icon(
                imageVector =
                if (index <= rating) {
                    Icons.Rounded.Star
                } else {
                    if (isHalfStar) {
                        isHalfStar = false
                        Icons.Rounded.Add
                    } else {
                        Icons.Rounded.AccountBox
                    }
                },
                contentDescription = null,
                tint = starsColor,
                modifier = Modifier
                    .size(18.dp)
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