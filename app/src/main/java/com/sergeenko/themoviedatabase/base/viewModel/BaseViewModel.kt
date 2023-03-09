package com.sergeenko.themoviedatabase.base.viewModel

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow

abstract class BaseViewModel<T>: ViewModel(){

    abstract val screenStateFlow: MutableStateFlow<T>

    val currentState: T
        get() = screenStateFlow.value


}