package com.tcs.coffee.domain.usecases

import com.tcs.coffee.data.model.response.Coffee
import com.tcs.coffee.data.network.state.RequestState
import com.tcs.coffee.domain.repository.CoffeeRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class GetHotCoffeesUseCase @Inject constructor(private val coffeeRepository: CoffeeRepository) {

    operator fun invoke(): Flow<RequestState<List<Coffee>>> = flow {

        try {
            emit(RequestState.Loading())
            val coffees = coffeeRepository.getHotCoffees()
            emit(RequestState.Success(coffees))
        } catch (e: Exception) {
            emit(RequestState.Failure(e.message ?: "An unexpected error occurred"))
        }

    }.flowOn(Dispatchers.IO)

}