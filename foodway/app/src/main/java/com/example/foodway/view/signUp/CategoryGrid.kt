package com.example.foodway.view.signUp

import CategoryCard
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun CategoryGrid(categories: List<String>) {
    LazyVerticalGrid(
        modifier = Modifier
            .fillMaxWidth(),
        columns = GridCells.Fixed(2),
        horizontalArrangement = Arrangement.spacedBy(20.dp),
        verticalArrangement = Arrangement.spacedBy(4.dp),
        userScrollEnabled = true
    ) {
        items(categories.size) { index ->
            CategoryCard(categories[index])
        }
    }
}

//@Preview(showBackground = true)
//@Composable
//fun CategoryGridPreview() {
//    CategoryGrid(categories = listOf("Categoria 1", "Categoria 2", "Categoria 3"))
//}
