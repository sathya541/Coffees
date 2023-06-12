package com.tcs.coffee.presentation.coffeelist

import com.tcs.coffee.data.model.response.Coffee
import com.tcs.coffee.presentation.base.IViewState

data class CoffeeListState(
    val isLoading: Boolean = false,
    val coffees: List<Coffee>? = emptyList(),
    val error: String = ""
) : IViewState