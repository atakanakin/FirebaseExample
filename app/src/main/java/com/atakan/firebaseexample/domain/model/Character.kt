package com.atakan.firebaseexample.domain.model

data class Character (
    val name: String,
    val status: String,
    val species: String,
    val gender: String,
    val origin: Origin,
    val location: Origin,
    val image: String,
    val created: String
)

data class Origin(
    val name: String,
    val url: String
)