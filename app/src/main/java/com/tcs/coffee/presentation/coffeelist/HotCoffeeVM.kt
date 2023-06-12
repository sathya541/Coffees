package com.tcs.coffee.presentation.coffeelist

import androidx.lifecycle.viewModelScope
import com.tcs.coffee.data.network.state.RequestState
import com.tcs.coffee.domain.usecases.GetHotCoffeesUseCase
import com.tcs.coffee.presentation.base.BaseViewModel
import com.tcs.coffee.presentation.coffeelist.CoffeeListState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class HotCoffeeVM @Inject constructor(
    private val getHotCoffeesUseCase: GetHotCoffeesUseCase,
) : BaseViewModel<CoffeeListState>() {

    override fun createInitialState() = CoffeeListState(coffees = emptyList())

    init {
        getHotCoffees()
    }

    private fun getHotCoffees() {

        getHotCoffeesUseCase().onEach { result ->

            when (result) {

                is RequestState.Loading -> {
                    setState(CoffeeListState(isLoading = true))
                }

                is RequestState.Success -> {
                    setState(CoffeeListState(isLoading = false))
                    setState(CoffeeListState(coffees = result.data ?: emptyList()))
                    _isRefreshing.emit(false)
                }

                is RequestState.Failure -> {
                    setState(CoffeeListState(isLoading = false))
                    setState(
                        CoffeeListState(
                            error = result.message ?: "Unexpected Error"
                        )
                    )

                    _isRefreshing.emit(false)
                }

            }

        }.launchIn(viewModelScope)

    }

}