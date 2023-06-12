package com.tcs.coffee.navigation

import com.tcs.coffee.R

sealed class Screen(
    val route: String,
    val title: String,
    val icon: Int
) {
    object HotCoffees : Screen(
        route = "hotcoffees",
        title = "Hot Coffees",
        icon = R.drawable.ic_hot_coffee
    )

    object IcedCoffees : Screen(
        route = "icedcoffees",
        title = "Iced Coffees",
        icon = R.drawable.ic_iced_coffee
    )

    object CoffeeDetails : Screen(
        route = "coffeedetails",
        title = "Coffee Details",
        icon = R.drawable.ic_iced_coffee
    )
}