package com.atakan.firebaseexample.data.remote.dto

import com.atakan.firebaseexample.domain.model.Rick

data class RickDto(
    val change:String
)

fun RickDto.toRick(): Rick {
    return Rick(
        change = change
    )
}