package com.tcs.coffee.presentation.landing

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.rememberNavController
import com.tcs.coffee.navigation.BottomNav
import com.tcs.coffee.navigation.NavGraph

@Composable
fun LandingScreen() {
    val navController = rememberNavController()

    Scaffold(
        bottomBar = {
            BottomNav(navController = navController)
        }
    ) { padding ->
        Column(
            modifier = Modifier.padding(padding)
        ) {
            NavGraph(navController = navController)
        }
    }

}

