package com.tcs.coffee.presentation.coffeelist

import android.annotation.SuppressLint
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material.*
import androidx.compose.material.pullrefresh.PullRefreshIndicator
import androidx.compose.material.pullrefresh.pullRefresh
import androidx.compose.material.pullrefresh.rememberPullRefreshState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavController
import com.tcs.coffee.navigation.Screen
import com.tcs.coffee.presentation.base.BaseViewModel
import com.tcs.coffee.presentation.components.GridItemAnimation
import com.tcs.coffee.R

@OptIn(ExperimentalMaterialApi::class)
@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@ExperimentalFoundationApi
@Composable
fun GridViewAnimation(
    navController: NavController,
    viewModel: BaseViewModel<CoffeeListState>,
    sharedCoffeeVM: SharedCoffeeVM
) {
    val state = viewModel.viewState.value

    if (state.isLoading) {
        Box(
            contentAlignment = Alignment.Center, modifier = Modifier.fillMaxSize()
        ) {
            CircularProgressIndicator(modifier = Modifier.align(Alignment.Center))
        }
    }

    if (state.error.isNotBlank()) {
        Text(
            text = state.error,
            color = MaterialTheme.colors.error,
            textAlign = TextAlign.Center,
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp)
        )
    }

    Scaffold(topBar = {
        TopAppBar(title = {
            Text(
                text = "Coffee",
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
    }) { innerPadding ->

        val isRefreshing by viewModel.isRefreshing.collectAsStateWithLifecycle()

        val pullRefreshState = rememberPullRefreshState(isRefreshing, { state.coffees })

        Box(
            Modifier
                .padding(innerPadding)
                .pullRefresh(pullRefreshState)
        ) {
            LazyVerticalGrid(
                columns = GridCells.Fixed(2),
            ) {
                items(state.coffees ?: listOf()) { coffee ->
                    GridItemAnimation(coffee, onItemClick = {
                        sharedCoffeeVM.addCoffee(selectedCoffee = it)
                        navController.navigate(Screen.CoffeeDetails.route)
                    })
                }
            }

            PullRefreshIndicator(
                refreshing = isRefreshing,
                state = pullRefreshState,
                modifier = Modifier.align(Alignment.TopCenter)
            )
        }
    }


}