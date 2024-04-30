package com.example.foodway.view.establishmentMenu

import android.content.Context
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedCard
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.Coil
import coil.ImageLoader
import coil.compose.AsyncImage
import coil.request.CachePolicy
import com.example.foodway.R
import com.example.foodway.model.Product

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ProductCard(
    data: Product
) {
    initializeCoil(LocalContext.current)
    OutlinedCard(
        onClick = { /*TODO*/ },
        modifier = Modifier
            .size(width = 200.dp, height = 150.dp)
            .padding(8.dp),
        shape = RoundedCornerShape(12.dp),
    ) {
        Column(modifier = Modifier.fillMaxSize()) {
            AsyncImage(
                model = data.photo,
                contentDescription = data.name,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .height(70.dp)
                    .fillMaxWidth()
            )
            Spacer(modifier = Modifier.height(4.dp))
            Column(
                modifier = Modifier.padding(8.dp)
            ) {
                Text(
                    text = data.name,
                    fontWeight = FontWeight.Bold,
                    fontSize = 14.sp,
                )
                Spacer(modifier = Modifier.height(4.dp))
                Text(
                    text = stringResource(id = R.string.product_price, data.value),
                    fontSize = 12.sp,
                )
            }
        }
    }
}

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

//@Preview(showBackground = true)
//@Composable
//fun ProductCardPreview() {
//    ProductCard()
//}

