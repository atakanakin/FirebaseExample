package com.atakan.firebaseexample.presentation.rick

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.atakan.firebaseexample.common.Resource
import com.atakan.firebaseexample.domain.model.Rick
import com.atakan.firebaseexample.domain.use_case.GetRickUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class RickViewModel @Inject constructor(
    private val getRickUseCase: GetRickUseCase
): ViewModel(){
    private val _state = mutableStateOf(RickState())
    val state: State<RickState> = _state

    init {
        getRick()
    }

    private fun getRick(){
        getRickUseCase().onEach{result ->
            when(result){
                is Resource.Success -> {
                    _state.value = RickState(rick = result.data ?: Rick(""))
                }
                is Resource.Error -> {
                    _state.value = RickState(
                        error = result.message ?: "Unexpected error occurred."
                    )
                }
                is Resource.Loading -> {
                    _state.value = RickState(
                        isLoading = true
                    )
                }
            }
        }
    }
}