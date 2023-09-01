package com.atakan.firebaseexample.domain.repository

import com.atakan.firebaseexample.data.remote.dto.CharacterDto

interface CharacterRepository {

    suspend fun getCharacterInfo(): CharacterDto
}