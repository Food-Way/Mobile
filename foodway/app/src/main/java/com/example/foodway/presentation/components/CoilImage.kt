package com.example.foodway.presentation.components

import android.content.Context
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import coil.Coil
import coil.ImageLoader
import coil.compose.AsyncImage
import coil.request.CachePolicy

fun initializeCoil(context: Context) {
    Coil.setImageLoader {
        ImageLoader.Builder(context)
            .crossfade(true)
            .allowHardware(false)
            .diskCachePolicy(CachePolicy.DISABLED)
            .memoryCachePolicy(CachePolicy.DISABLED)
            .networkCachePolicy(CachePolicy.ENABLED)
            .build()
    }
}

@Composable
fun CoilImage(photo: String?, description: String?, modifier: Modifier) {
    initializeCoil(LocalContext.current)

    AsyncImage(
        model = photo ?: "https://foodway.s3.amazonaws.com/public-images/cat-unknown.png",
        contentDescription = description ?: "Imagem não encontrada",
        contentScale = ContentScale.Crop,
        modifier = modifier
    )

    if (photo != "https://foodway.s3.amazonaws.com/public-images/default-user-image.webp") {
        Surface(
            color = Color.Black.copy(alpha = 0.5f),
//            modifier = Modifier.fillMaxSize()
        ) {}
    }
}