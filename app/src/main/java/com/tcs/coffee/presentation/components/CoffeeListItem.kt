package com.tcs.coffee.presentation.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberImagePainter
import com.tcs.coffee.data.model.response.Coffee

@Composable
fun CoffeeItem(coffee: Coffee, onItemClick: (Coffee) -> Unit) {

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(14.dp)
            .clickable { onItemClick(coffee) },
        elevation = 16.dp
    ) {

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(18.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            val painter = rememberImagePainter(data = coffee.image)

            Image(
                painter = painter,
                contentDescription = "Coffee Image",
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .height(320.dp)
                    .fillMaxWidth()
                    .clip(RoundedCornerShape(12.dp))
            )

            Text(text = coffee.title ?: "", fontSize = 18.sp, fontWeight = FontWeight.Bold)

            Text(text = coffee.description ?: "", textAlign = TextAlign.Center)

            LazyRow(
                horizontalArrangement = Arrangement.spacedBy(
                    4.dp,
                    alignment = Alignment.CenterHorizontally
                ),
                modifier = Modifier
                    .fillMaxWidth(),
            ) {
                items(items = coffee.ingredients ?: listOf()) { ingredient ->
                    IngredientChip(text = ingredient)
                }
            }
        }
    }
}

