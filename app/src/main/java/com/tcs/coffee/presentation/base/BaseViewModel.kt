package com.tcs.coffee.presentation.base

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

abstract class BaseViewModel<ViewState : IViewState> : ViewModel() {

    private val initialState: ViewState by lazy { createInitialState() }

    abstract fun createInitialState(): ViewState

    private val _viewState: MutableState<ViewState> = mutableStateOf(initialState)
    val viewState: State<ViewState> = _viewState

    protected fun setState(state: ViewState) {
        _viewState.value = state
    }

    val _isRefreshing = MutableStateFlow(false)

    val isRefreshing: StateFlow<Boolean>
        get() = _isRefreshing.asStateFlow()

}