package com.example.foodway.view.profileEstablishment

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableDoubleStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import com.example.foodway.view.components.RatingBar


// Definição de cores
val redColor = Color(0xFFD32F2F)
val graySurface = Color(0xFFE0E0E0)

@Composable
fun CommentDialog(
    onConfirmAction: () -> Unit = {},
    onDismissRequest: () -> Unit = {},
    modifier: Modifier = Modifier
) {

    var rating by remember {
        mutableDoubleStateOf(2.5)
    }

    Dialog(onDismissRequest = { onDismissRequest() }) {
        Card(
            modifier = modifier
                .fillMaxWidth()
                .padding(16.dp)
                .background(Color.White),
            shape = RoundedCornerShape(8.dp),
            elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
        ) {
            Column(
                modifier = Modifier
                    .padding(16.dp)
                    .fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = "Mc donalds",
                    fontWeight = FontWeight.Bold,
                    fontSize = 18.sp
                )
                Text(
                    text = "Culinária Havaiana",
                    fontSize = 14.sp,
                    color = Color.Gray
                )
                Spacer(modifier = Modifier.height(8.dp))
                RatingBar(
                    rating = rating,
                    stars = 5,
                    onRatingChanged = {
                        rating = it
                    },
                    starsColor = Color.Yellow,
                    editable = true
                ) // A função RatingBar precisa ser definida
                Spacer(modifier = Modifier.height(16.dp))
                BasicTextField(
                    value = "",
                    onValueChange = {},
                    decorationBox = { innerTextField ->
                        Row(
                            Modifier
                                .background(graySurface, RoundedCornerShape(4.dp))
                                .padding(horizontal = 16.dp, vertical = 12.dp)
                                .fillMaxWidth()
                        ) {
//                            if (/* your text field is empty */) {
                            Text("Digite um comentário ✏️", color = Color.LightGray)
//                            }
                            innerTextField()
                        }
                    }
                )
                Spacer(modifier = Modifier.height(16.dp))
                Button(
                    onClick = { onConfirmAction() },
                    shape = RoundedCornerShape(5.dp),
                    colors = ButtonDefaults.buttonColors(containerColor = redColor),
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text(text = "Enviar", color = Color.White)
                }
                TextButton(
                    onClick = { onDismissRequest() },
                    modifier = Modifier.padding(top = 8.dp)
                ) {
                    Text(text = "Fechar", fontWeight = FontWeight.Bold, color = redColor)
                }
            }
        }
    }
}

@Preview(showBackground = false)
@Composable
fun CommentDialogPreview() {
    CommentDialog()
}