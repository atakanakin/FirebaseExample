package com.atakan.firebaseexample.presentation.rick

import com.atakan.firebaseexample.domain.model.Rick

data class RickState (
    val isLoading: Boolean = false,
    val rick: Rick = Rick(""),
    val error: String = ""
)