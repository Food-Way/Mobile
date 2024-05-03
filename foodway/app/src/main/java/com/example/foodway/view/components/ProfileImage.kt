package com.example.foodway.view.components

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.example.foodway.R

@Composable
fun ProfileImage(
    photo: String,
    size: Dp
) {

    CoilImage(
        photo = photo,
        description = stringResource(id = R.string.image_profile_desc),
        modifier = Modifier
            .size(size)
            .clip(CircleShape)
            .padding(0.dp),
    )


//    Image(
//        painter = painterResource(id = R.drawable.goku),
//
//        contentScale = ContentScale.Fit
//    )
}

//@Preview(showBackground = true)
//@Composable
//fun ProfileImagePreview() {
//    ProfileImage(size = 75.dp)
//}
