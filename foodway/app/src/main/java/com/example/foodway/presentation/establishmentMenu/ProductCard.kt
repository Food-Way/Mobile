package com.example.foodway.presentation.establishmentMenu

import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedCard
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.foodway.R
import com.example.foodway.domain.establishmentMenu.model.Product
import com.example.foodway.presentation.components.CoilImage
import com.example.foodway.presentation.components.Dialog
import java.util.UUID

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ProductCard(
    data: Product
) {
    var showModal by remember {
        mutableStateOf(false)
    }

    if (showModal) {
        Dialog(
            onDismissRequest = {
                showModal = false
            },
            content = { ProductDialog(
                name = data.name,
                photo = data.photo ?: "https://foodway.s3.amazonaws.com/public-images/product-image.webp",
                description = data.description ?: "Sem descrição",
                price = data.value,
                modifier = Modifier
                    .fillMaxWidth()
                    .clip(RoundedCornerShape(10.dp))
                    .height(150.dp),
                onDismissRequest = { showModal = false}
            )}
        )
    }

    OutlinedCard(
        colors = CardDefaults.cardColors(
            containerColor = colorResource(id = R.color.white)
        ),
        onClick = { showModal = !showModal },
        modifier = Modifier
            .size(width = 200.dp, height = 150.dp)
            .padding(8.dp),
        shape = RoundedCornerShape(12.dp),
    ) {
        Column(modifier = Modifier.fillMaxSize()) {
            CoilImage(
                photo = data.photo ?: "https://foodway.s3.amazonaws.com/public-images/product-image.webp",
                description = data.name ?: "Sem nome",
                modifier = Modifier
                    .height(70.dp)
                    .fillMaxWidth(),
                type = "cardProduct"
            )

            Spacer(modifier = Modifier.height(4.dp))

            Column(
                modifier = Modifier.padding(8.dp)
            ) {
                if (data.name.length > 10) {
                    MovingText(data.name ?: "Sem nome")
                } else {
                    Text(
                        text = data.name ?: "Sem nome",
                        fontWeight = FontWeight.Bold,
                        fontSize = 14.sp,
                    )
                }
                Spacer(modifier = Modifier.height(4.dp))
                Text(
                    text = stringResource(id = R.string.product_price, data.value),
                    fontSize = 12.sp,
                )
            }
        }
    }
}

@Composable
fun MovingText(contentText: String) {
    val infiniteTransition = rememberInfiniteTransition()

    val animatedOffsetX by infiniteTransition.animateFloat(
        initialValue = 100f,
        targetValue = -100f,
        animationSpec = infiniteRepeatable(
            animation = tween(durationMillis = 4000, easing = LinearEasing),
            repeatMode = RepeatMode.Restart
        )
    )

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(20.dp)
    ) {
        Text(
            fontWeight = FontWeight.Bold,
            fontSize = 14.sp,
            softWrap = false,
            maxLines = 1,
            text = contentText,
            modifier = Modifier.offset(x = animatedOffsetX.dp)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewProductCard() {
    val sampleProduct = Product(
        idProduct = UUID.randomUUID(),
        name = "Cadeira Gamer",
        description = "Cadeira gamer confortável e ergonômica, ideal para longas horas de jogo.",
        photo = "https://example.com/photo.jpg",
        value = 299.99
    )

    ProductCard(data = sampleProduct)
}

