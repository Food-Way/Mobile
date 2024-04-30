package com.example.foodway.view.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun <T> CardGrid(
    list: List<T>,
    buildItem: @Composable (T) -> Unit,
    modifier: Modifier = Modifier
) {
    LazyVerticalGrid(
        modifier = modifier
            .fillMaxWidth()
            .padding(16.dp),
        columns = GridCells.Fixed(2),
        horizontalArrangement = Arrangement.spacedBy(20.dp),
        verticalArrangement = Arrangement.spacedBy(20.dp),
        userScrollEnabled = true
    ) {
        items(list) { item ->
            buildItem(item)
        }
    }
}

//@Preview(showBackground = true)
//@Composable
//fun CategoryGridPreview() {
//    CategoryGrid(categories = listOf("Categoria 1", "Categoria 2", "Categoria 3"))
//}
