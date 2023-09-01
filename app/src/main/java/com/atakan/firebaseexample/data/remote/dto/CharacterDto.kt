package com.atakan.firebaseexample.data.remote.dto

import com.atakan.firebaseexample.domain.model.Character
import com.atakan.firebaseexample.domain.model.Origin

data class CharacterDto(
    val id: Int,
    val name: String,
    val status: String,
    val species: String,
    val type: String,
    val gender: String,
    val origin: Origin,
    val location: Origin,
    val image: String,
    val episode: List<String>,
    val url: String,
    val created: String
)


fun CharacterDto.toCharacter(): Character {
    return Character(
        name, status, species, gender, origin, location, image, created
    )
}