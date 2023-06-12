package com.tcs.coffee.presentation.components

import android.net.Uri
import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberImagePainter
import com.tcs.coffee.data.model.response.Coffee
import com.tcs.coffee.R

@Composable
fun GridItemAnimation(
    coffee: Coffee, onItemClick: (Coffee) -> Unit
) {
    val animatedProgress = remember { Animatable(initialValue = -300f) }
    val opacityProgress = remember { Animatable(initialValue = 0f) }

    LaunchedEffect(Unit) {
        animatedProgress.animateTo(
            targetValue = 0f,
            animationSpec = tween(300, easing = LinearEasing)
        )
        opacityProgress.animateTo(
            targetValue = 1f,
            animationSpec = tween(600)
        )
    }

    val animatedModifier = Modifier
        .padding(8.dp)
        .graphicsLayer(translationX = animatedProgress.value)
        .alpha(opacityProgress.value)

//    val painter = rememberImagePainter(data = coffee.image)

    Card(
        modifier = Modifier
            .padding(10.dp)
            .clickable { onItemClick(coffee) },
        elevation = 10.dp,
        shape = RoundedCornerShape(10.dp)
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
            modifier = animatedModifier
        ) {

            val localImagePainterUrl = remember { mutableStateOf<Uri?>(null) }
            val painter = rememberImagePainter(
                data = localImagePainterUrl.value
                    ?: coffee.image
                    ?: R.drawable.ic_coffee_placeholder,
                builder = {
                    placeholder(R.drawable.ic_coffee_placeholder)
                })
//            val isError = painter.state is ImagePainter.State.Error


            /*AsyncImage(
                model = ImageRequest.Builder(LocalContext.current)
                    .data(coffee.image)
                    .crossfade(true)
                    .build(),
                placeholder = painterResource(R.drawable.ic_coffee_placeholder),
                contentDescription = "Coffee Image",
                contentScale = ContentScale.Crop,
                modifier = Modifier.size(300.dp)
            )*/


            Image(
                painter = painter,
                contentDescription = "Coffee Image",
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .height(80.dp)
                    .fillMaxWidth()
                    .clip(RoundedCornerShape(8.dp))
            )

            Text(
                text = coffee.title ?: "",
                style = MaterialTheme.typography.h6.copy(fontSize = 16.sp),
                color = MaterialTheme.colors.onSurface
            )

            /*Text(
                text = coffee.description ?: "",
                style = MaterialTheme.typography.subtitle2,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis,
                color = Color.Gray
            )*/
        }
    }

}