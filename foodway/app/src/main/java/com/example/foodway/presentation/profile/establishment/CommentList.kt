package com.example.foodway.presentation.profile.establishment

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
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
        modifier = Modifier
            .fillMaxWidth()
            .height(285.dp),
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .fillMaxWidth()
                .verticalScroll(scrollState)) {
            repeat(comments.size) {
                comments[it].replies?.let { commentChild ->
                    CommentItem(
                        width = 300.dp,
                        height = 180.dp,
                        isChild = false,
                        idComment = comments[it].idPost,
                        photo = comments[it].userPhoto,
                        comment = comments[it].comment,
                        rate = comments[it].generalRate,
                        qtdUpvotes = comments[it].upvotes,
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