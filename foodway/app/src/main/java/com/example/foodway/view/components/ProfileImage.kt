package com.example.foodway.view.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.example.foodway.R

@Composable
fun ProfileImage(size: Dp) {
    Image(
        painter = painterResource(id = R.drawable.goku),
        contentDescription = stringResource(id = R.string.image_profile_desc),
        modifier = Modifier
            .size(size)
            .clip(CircleShape)
            .padding(0.dp),
        contentScale = ContentScale.Fit
    )
}

@Preview(showBackground = true)
@Composable
fun ProfileImagePreview() {
    ProfileImage(size = 75.dp)
}
