package com.atakan.firebaseexample.data.remote.dto

import com.atakan.firebaseexample.domain.model.Character


data class AllDto (
    val info: Info,
    val results: List<CharacterDto>
)

data class Info (
    val count: Int,
    val pages: Int,
    val next: String?,
    val prev: String?
)

fun AllDto.toCharacter(): List<Character> {
    val characterList = mutableListOf<Character>()

    results.forEach{
        characterList.add(it.toCharacter())
    }
    return characterList
}