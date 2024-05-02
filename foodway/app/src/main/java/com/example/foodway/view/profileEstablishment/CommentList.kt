package com.example.foodway.view.profileEstablishment

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.foodway.model.Comment

@Composable
fun CommentList(
    comments: List<Comment>
) {
    val scrollState = rememberScrollState()
    Box(
        Modifier.height(400.dp),
    ) {
        Column(modifier = Modifier.verticalScroll(scrollState)) {
            repeat(comments.size) {
                Comment(
                    width = 250.dp,
                    height = 160.dp,
                    isChild = false
                )
            }
        }
    }
}

//@Preview(showBackground = true)
//@Composable
//fun CommentListPreview() {
//    CommentList()
//}