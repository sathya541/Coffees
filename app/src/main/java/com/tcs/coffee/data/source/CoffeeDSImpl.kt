package com.tcs.coffee.data.source

import com.tcs.coffee.data.network.api.ApiService
import javax.inject.Inject

class CoffeeDSImpl @Inject constructor(
    private val apiService: ApiService
) : CoffeeDS {

    override suspend fun getHotCoffees() = apiService.getHotCoffees()

    override suspend fun getIcedCoffees() = apiService.getIcedCoffees()
}