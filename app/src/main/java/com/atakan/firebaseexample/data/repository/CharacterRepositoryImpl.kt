package com.atakan.firebaseexample.data.repository

import com.atakan.firebaseexample.data.remote.CharacterApi
import com.atakan.firebaseexample.data.remote.dto.CharacterDto
import com.atakan.firebaseexample.domain.repository.CharacterRepository
import javax.inject.Inject

class CharacterRepositoryImpl @Inject constructor(
    private val api: CharacterApi
): CharacterRepository{

    override suspend fun getCharacterInfo(): CharacterDto {
        return api.getCharacterInfo()
    }
}