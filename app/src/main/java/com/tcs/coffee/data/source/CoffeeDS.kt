package com.tcs.coffee.data.source

import com.tcs.coffee.data.model.response.Coffee

interface CoffeeDS {

    suspend fun getHotCoffees(): List<Coffee>

    suspend fun getIcedCoffees(): List<Coffee>

}