package com.tcs.coffee.navigation

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.BottomNavigation
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.tcs.coffee.presentation.theme.Brown
import com.tcs.coffee.presentation.ui_helper.AddItem

@Composable
fun BottomNav(navController: NavHostController) {
    val screens = listOf(
        Screen.HotCoffees,
        Screen.IcedCoffees,
    )
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentDestination = navBackStackEntry?.destination

    BottomNavigation(
        backgroundColor = Brown,
        modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(4.dp, 4.dp, 0.dp, 0.dp))
    ) {
        screens.forEach { screen ->
            AddItem(
                screen = screen,
                currentDestination = currentDestination,
                navController = navController
            )
        }
    }
}