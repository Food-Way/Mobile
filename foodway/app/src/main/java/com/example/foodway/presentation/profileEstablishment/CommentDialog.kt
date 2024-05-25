package com.example.foodway.presentation.profileEstablishment

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
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
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.foodway.R
import com.example.foodway.view.components.ButtonGeneric
import com.example.foodway.view.components.RatingBar

@Composable
fun CommentDialog(
    onDismissRequest: () -> Unit,
) {
    var rating by remember {
        mutableDoubleStateOf(2.5)
    }

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
        )
        Spacer(modifier = Modifier.height(16.dp))
        BasicTextField(
            value = "",
            onValueChange = {},
            decorationBox = { innerTextField ->
                Row(
                    Modifier
                        .background(
                            color = colorResource(id = R.color.red),
                            RoundedCornerShape(4.dp)
                        )
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

        ButtonGeneric(
            text = "Enviar",
            modifier = Modifier
                .width(200.dp)
                .height(200.dp),
            isPrimary = true,
        ) {}

        TextButton(
            onClick = { onDismissRequest() },
            modifier = Modifier.padding(top = 8.dp)
        ) {
            Text(text = "Fechar", fontWeight = FontWeight.Bold, color = Color.Red)
        }
    }
}


@Preview(showBackground = true)
@Composable
fun CommentDialogPreview() {
    CommentDialog() {}
}