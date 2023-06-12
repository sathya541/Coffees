package com.tcs.coffee.data.di

import com.tcs.coffee.data.network.api.ApiService
import com.tcs.coffee.data.repository.CoffeeRepositoryImpl
import com.tcs.coffee.data.source.CoffeeDS
import com.tcs.coffee.data.source.CoffeeDSImpl
import com.tcs.coffee.domain.repository.CoffeeRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
object DataModule {

    @Provides
    fun provideCoffeeDataSource(coffeeService: ApiService): CoffeeDS = CoffeeDSImpl(coffeeService)

    @Provides
    fun provideCoffeeRepository(coffeeDataSource: CoffeeDS): CoffeeRepository =
        CoffeeRepositoryImpl(coffeeDataSource)

}