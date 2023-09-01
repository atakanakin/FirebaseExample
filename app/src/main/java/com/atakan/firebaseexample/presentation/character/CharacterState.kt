package com.atakan.firebaseexample.presentation.character

import com.atakan.firebaseexample.domain.model.Character
import com.atakan.firebaseexample.domain.model.Origin

data class CharacterState (
    val isLoading: Boolean = false,
    val character: List<Character> = emptyList(),
    val error: String = ""
)