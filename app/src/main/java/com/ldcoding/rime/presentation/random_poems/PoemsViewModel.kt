package com.ldcoding.rime.presentation.random_poems

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ldcoding.rime.common.Resource
import com.ldcoding.rime.domain.usecase.get_random_poems.GetPoemsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class PoemsViewModel @Inject constructor(
    private val getPoemsUseCase: GetPoemsUseCase,
) : ViewModel() {

    private val _state = mutableStateOf(PoemsListState())
    val state: State<PoemsListState> = _state

    init {
        getPoems()
    }

    private fun getPoems() {
        getPoemsUseCase().onEach { result ->
            when (result) {
                is Resource.Success -> {
                    _state.value = PoemsListState(poems = result.data ?: emptyList())
                }
                is Resource.Error -> {
                    _state.value = PoemsListState(
                        error = result.message ?: "An unexpected error occured"
                    )
                }
                is Resource.Loading -> {
                    _state.value = PoemsListState(isLoading = false)
                }
            }
        }.launchIn(viewModelScope)
    }
}