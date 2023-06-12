package com.tcs.coffee.presentation.coffeelist

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import coil.compose.rememberImagePainter
import com.tcs.coffee.R
import com.tcs.coffee.presentation.components.IngredientChip

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun CoffeeDetailsFragment(
    navController: NavController,
    sharedCoffeeVM: SharedCoffeeVM
) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = "Coffee Details",
                        modifier = Modifier.fillMaxWidth(),
                        textAlign = TextAlign.Start
                    )
                }, navigationIcon = {
                    IconButton(
                        onClick = {},
                        modifier = Modifier
                            .height(24.dp)
                            .fillMaxWidth()
                    ) {
                        Icon(
                            ImageVector.vectorResource(id = R.drawable.ic_coffee_placeholder),
                            "Top Bar Icon"
                        )
                    }
                })
        }
    ) {
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(14.dp),
            elevation = 16.dp
        ) {

            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(18.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                val painter = rememberImagePainter(data = sharedCoffeeVM.coffee?.image)

                Image(
                    painter = painter,
                    contentDescription = "Coffee Image",
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .height(320.dp)
                        .fillMaxWidth()
                        .clip(RoundedCornerShape(12.dp))
                )

                Text(
                    text = sharedCoffeeVM.coffee?.title ?: "",
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold
                )

                Text(text = sharedCoffeeVM.coffee?.description ?: "", textAlign = TextAlign.Center)

                LazyRow(
                    horizontalArrangement = Arrangement.spacedBy(
                        4.dp,
                        alignment = Alignment.CenterHorizontally
                    ),
                    modifier = Modifier
                        .fillMaxWidth(),
                ) {
                    items(items = sharedCoffeeVM.coffee?.ingredients ?: listOf()) { ingredient ->
                        IngredientChip(text = ingredient)
                    }
                }
            }

        }
    }

}