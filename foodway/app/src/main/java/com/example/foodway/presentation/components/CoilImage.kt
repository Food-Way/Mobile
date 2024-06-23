package com.example.foodway.presentation.components

import android.content.Context
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
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
fun CoilImage(photo: String?, description: String?, modifier: Modifier, type: String) {
    initializeCoil(LocalContext.current)

//    AsyncImage(
//        model = photo ?: "https://foodway.s3.amazonaws.com/public-images/cat-unknown.png",
//        contentDescription = description ?: "Imagem não encontrada",
//        contentScale = ContentScale.Crop,
//        modifier = modifier
//    )

    if (type == "profile") {
        Box {
            AsyncImage(
                model = photo ?: "https://foodway.s3.amazonaws.com/public-images/cat-unknown.png",
                contentDescription = description ?: "Imagem não encontrada",
                contentScale = ContentScale.Crop,
                modifier = modifier
            )
            Surface(
                color = Color.Black.copy(alpha = 0.5f),
                modifier = Modifier
                    .width(80.dp)
                    .height(80.dp)
                    .clip(RoundedCornerShape(50.dp))
            ) {}
        }
    } else if(type == "card") {
        Box {
            AsyncImage(
                model = photo ?: "https://foodway.s3.amazonaws.com/public-images/cat-unknown.png",
                contentDescription = description ?: "Imagem não encontrada",
                contentScale = ContentScale.Crop,
                modifier = modifier
            )
            Surface(
                color = Color.Black.copy(alpha = 0.5f),
                modifier = Modifier.fillMaxSize()
            ) {}
        }
    } else if(type == "miniProfile") {
        Box {
            AsyncImage(
                model = photo ?: "https://foodway.s3.amazonaws.com/public-images/cat-unknown.png",
                contentDescription = description ?: "Imagem não encontrada",
                contentScale = ContentScale.Crop,
                modifier = modifier
            )
            Surface(
                color = Color.Black.copy(alpha = 0.5f),
                modifier = Modifier
                    .width(35.dp)
                    .height(35.dp)
                    .clip(RoundedCornerShape(50.dp))
            ) {}
        }
    } else if(type == "cardProduct") {
        Box {
            AsyncImage(
                model = photo ?: "https://foodway.s3.amazonaws.com/public-images/cat-unknown.png",
                contentDescription = description ?: "Imagem não encontrada",
                contentScale = ContentScale.Crop,
                modifier = modifier
            )
            Surface(
                color = Color.Black.copy(alpha = 0.5f),
                modifier = Modifier
                    .fillMaxWidth()
                    .height(70.dp)
            ) {}
        }
    } else if(type == "cardProductDialog") {
        Box {
            AsyncImage(
                model = photo ?: "https://foodway.s3.amazonaws.com/public-images/cat-unknown.png",
                contentDescription = description ?: "Imagem não encontrada",
                contentScale = ContentScale.Crop,
                modifier = modifier
            )
            Surface(
                color = Color.Black.copy(alpha = 0.5f),
                modifier = Modifier
                    .fillMaxWidth()
                    .height(150.dp)
                    .clip(RoundedCornerShape(10.dp))
            ) {}
        }
    }
}