package com.tcs.coffee.navigation

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.tcs.coffee.presentation.coffeelist.HotCoffeeVM
import com.tcs.coffee.presentation.coffeelist.IcedCoffeeVM
import com.tcs.coffee.presentation.coffeelist.SharedCoffeeVM
import com.tcs.coffee.presentation.coffeelist.CoffeeDetailsFragment
import com.tcs.coffee.presentation.coffeelist.GridViewAnimation

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun NavGraph(navController: NavHostController) {

    val sharedCoffeeVM: SharedCoffeeVM = viewModel()

    NavHost(
        navController = navController,
        startDestination = Screen.HotCoffees.route
    ) {
        composable(route = Screen.HotCoffees.route) {
            val viewModel: HotCoffeeVM = hiltViewModel()
            GridViewAnimation(navController, viewModel, sharedCoffeeVM)
        }

        composable(route = Screen.IcedCoffees.route) {
            val viewModel: IcedCoffeeVM = hiltViewModel()
            GridViewAnimation(navController, viewModel, sharedCoffeeVM)
        }

        composable(route = Screen.CoffeeDetails.route) {
            CoffeeDetailsFragment(navController, sharedCoffeeVM)
        }


    }
}