package com.example.foodway.view.profileEstablishment

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.foodway.ui.theme.FoodwayTheme
import com.example.foodway.view.components.Dialog

class ProfileEstablishmentActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            FoodwayTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    ProfileEstablishment()
                }
            }
        }
    }
}

@Composable
fun ProfileEstablishment() {
    var showModal by remember {
        mutableStateOf(false)
    }

    if (showModal) {
        Dialog(
            onDismissRequest = {
                showModal = false
            },
            content = { CommentDialog() }
        )
    }

    Scaffold(
        bottomBar = {}
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.SpaceAround
        ) {
            ProfileInfoCard(
                modifier = Modifier
                    .padding(innerPadding)
            )
            CommentList()
            CommentBoxHandler(
                showCommentDialog = {
                    showModal = true
                }
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ProfileEstablishmentPreview() {
    ProfileEstablishment()
}