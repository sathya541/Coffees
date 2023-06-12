package com.tcs.coffee.domain.repository

import com.tcs.coffee.data.model.response.Coffee

interface CoffeeRepository {

    suspend fun getHotCoffees(): List<Coffee>

    suspend fun getIcedCoffees(): List<Coffee>

}