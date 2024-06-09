package com.example.foodway.presentation.edit

import android.util.Log
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Send
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.example.foodway.R
import com.example.foodway.presentation.components.ProfileImage

@Composable
fun UploadImage(
    modifier: Modifier = Modifier,
    imageUri: String = "",
    onChangeImage: (String) -> Unit = {},
    onclick: () -> Unit = {},
    size: Dp
) {

    val launcher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.GetContent()
    ) { uri ->
        uri?.let {
            onChangeImage(it.toString())
            Log.i("Profile Image", "valor da imageUri: $it")
        }
    }
    Column(
        modifier = Modifier
            .padding(4.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Box(
            modifier = Modifier
                .clickable { launcher.launch("image/*") }
        ) {
            Card(
                shape = CircleShape,
                border = BorderStroke(2.dp, colorResource(id = R.color.light_gray)),
                modifier = Modifier
                    .padding(8.dp)
                    .size(80.dp)
            ) {
                ProfileImage(photo = imageUri, size = size)
            }
            Icon(
                imageVector = Icons.Filled.Send,
                contentDescription = "add profile picture",
                tint = Color.Red,
                modifier = Modifier
                    .offset(x = (0).dp, y = (-10).dp)
                    .background(
                        Color.White,
                        RoundedCornerShape(100)
                    )
                    .border(3.dp, colorResource(id = R.color.red), CircleShape)
                    .padding(10.dp)
                    .size(20.dp)
                    .align(Alignment.BottomEnd)
                    .clickable {
                        onclick()
                    }
            )
        }
    }
}