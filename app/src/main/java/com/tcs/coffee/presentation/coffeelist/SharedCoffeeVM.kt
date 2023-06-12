package com.tcs.coffee.presentation.coffeelist

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.tcs.coffee.data.model.response.Coffee

class SharedCoffeeVM : ViewModel() {

    var coffee by mutableStateOf<Coffee?>(null)
        private set

    fun addCoffee(selectedCoffee: Coffee) {
        coffee = selectedCoffee
    }
}