package com.atakan.firebaseexample.presentation.character

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.atakan.firebaseexample.common.Resource
import com.atakan.firebaseexample.domain.use_case.GetCharacterUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject
import com.atakan.firebaseexample.domain.model.Character
import kotlinx.coroutines.flow.launchIn
import com.atakan.firebaseexample.domain.model.Origin

@HiltViewModel
class CharacterViewModel @Inject constructor(
    private val getCharacterUseCase: GetCharacterUseCase
): ViewModel(){
    private val _state = mutableStateOf(CharacterState())
    val state: State<CharacterState> = _state

    init {
        getCharacter()
    }

    private fun getCharacter(){
        getCharacterUseCase().onEach{result ->
            when(result){
                is Resource.Success -> {
                    _state.value = CharacterState(character = result.data ?: emptyList())
                }
                is Resource.Error -> {
                    _state.value = CharacterState(
                        error = result.message ?: "Unexpected error occurred."
                    )
                }
                is Resource.Loading -> {
                    _state.value = CharacterState(
                        isLoading = true
                    )
                }
            }
        }.launchIn(viewModelScope)
    }
}