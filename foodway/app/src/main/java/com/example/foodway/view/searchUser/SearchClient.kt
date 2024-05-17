package com.example.foodway.view.searchUser

import UserSearchComponent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.foodway.view.components.CardUser
import com.example.foodway.view.components.ListCardUser


@Composable
fun SearchClient() {
    var users = mutableListOf("", "", "", "")

    Column {
        UserSearchComponent() {}
        Column {
            Text(
                modifier = Modifier
                    .padding(0.dp, 13.dp),
                text = "Populares ⭐",
                fontWeight = FontWeight.Bold,
                fontSize = 18.sp
            )
            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier
                    .fillMaxWidth()
            ) {
                var topTree = listOf('1', '2', '3')

                topTree.forEach { user ->
                    CardUser()
                }
            }
        }
        Column(
            modifier = Modifier
                .padding(top = 10.dp),
        ) {
            Text(
                modifier = Modifier
                    .padding(0.dp, 13.dp),
                text = "Você também vai gostar 😋",
                fontWeight = FontWeight.Bold,
                fontSize = 18.sp
            )
            LazyColumn(
                modifier = Modifier
                    .height(300.dp),
                verticalArrangement = Arrangement.SpaceAround
            ) {
                items(users.size) { index ->
//                    ListCardUser()
                }
            }
        }
    }
}

@Preview
@Composable
fun SearchClientPreview() {
    SearchClient()
}