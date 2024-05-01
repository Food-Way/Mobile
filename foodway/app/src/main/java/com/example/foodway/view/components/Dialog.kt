package com.example.foodway.view.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog

@Composable
fun Dialog(
    modifier: Modifier = Modifier,
    onConfirmAction: () -> Unit = {},
    onDismissRequest: () -> Unit = {},
    content: @Composable () -> Unit
) {
    Dialog(onDismissRequest = { onDismissRequest() }) {
        Card(
            modifier = modifier
                .fillMaxWidth()
                .padding(16.dp)
                .background(Color.White),
            shape = RoundedCornerShape(8.dp),
            elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
        ) {
            content()
        }
    }
}

//@Preview(showBackground = false)
//@Composable
//fun Preview() {
//    Dialog()
//}