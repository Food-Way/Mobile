package com.example.foodway.view.profileEstablishment

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun CommentList() {
    val scrollState = rememberScrollState()
    Box(
        Modifier.height(400.dp),
    ) {
        Column(modifier = Modifier.verticalScroll(scrollState)){
            Comment(width = 250.dp, height = 160.dp, isChild = false)
            Comment(width = 250.dp, height = 160.dp, isChild = false)
            Comment(width = 250.dp, height = 160.dp, isChild = false)
            Comment(width = 250.dp, height = 160.dp, isChild = false)
            Comment(width = 250.dp, height = 160.dp, isChild = false)
            Comment(width = 250.dp, height = 160.dp, isChild = false)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun CommentListPreview() {
    CommentList()
}