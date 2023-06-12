package com.tcs.coffee.data.repository

import com.tcs.coffee.data.source.CoffeeDS
import com.tcs.coffee.domain.repository.CoffeeRepository
import javax.inject.Inject

class CoffeeRepositoryImpl @Inject constructor(
    private val coffeeDataSource: CoffeeDS,
) : CoffeeRepository {

    override suspend fun getHotCoffees() = coffeeDataSource.getHotCoffees()

    override suspend fun getIcedCoffees() = coffeeDataSource.getIcedCoffees()

}