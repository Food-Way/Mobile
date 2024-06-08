package com.example.foodway.presentation.profile.establishment

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.foodway.domain.model.Comment

@Composable
fun CommentList(
    comments: List<Comment>
) {
    val scrollState = rememberScrollState()
    Box(
        Modifier
            .fillMaxWidth()
            .height(400.dp)
            .background(Color.Yellow),
    ) {
        Column(modifier = Modifier.verticalScroll(scrollState)) {
            repeat(comments.size) {
                comments[it].commentChild?.let { commentChild ->
                    CommentItem(
                        width = 250.dp,
                        height = 160.dp,
                        isChild = false,
                        idComment = comments[it].idComment,
                        name = comments[it].name,
                        photo = comments[it].photo,
                        comment = comments[it].comment,
                        rate = comments[it].rate,
                        qtdUpvotes = comments[it].qtdUpvotes,
                        commentChild = commentChild
                    )
                }
            }
        }
    }
}

//@Preview(showBackground = true)
//@Composable
//fun CommentListPreview() {
//    CommentList()
//}