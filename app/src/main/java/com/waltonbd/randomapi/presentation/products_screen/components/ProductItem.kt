package com.waltonbd.randomapi.presentation.products_screen.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp


/**
 * Created by Ahsan Habib on 5/28/2024.
 */
@Composable
fun ProductItem(
    modifier: Modifier = Modifier,
    productName: String,
    categoryName: String,
    onAddClick: () -> Unit,
) {
    Card(
        modifier = modifier
            .fillMaxWidth(),
        border = BorderStroke(2.dp, Color.Gray),
    ) {
        Row(
            modifier = modifier.padding(8.dp)
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Column {
                Text(
                    text = productName,
                    style = MaterialTheme.typography.titleLarge
                )
                Text(
                    text = categoryName,
                    style = MaterialTheme.typography.titleMedium
                )
            }
            Icon(
                imageVector = Icons.Default.Add,
                contentDescription = "Add",
                modifier = Modifier.align(Alignment.CenterVertically)
                    .clickable(onClick = onAddClick),
            )

        }
    }
}

//}