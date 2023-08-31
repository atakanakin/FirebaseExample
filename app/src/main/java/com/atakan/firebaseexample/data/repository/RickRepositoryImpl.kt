package com.atakan.firebaseexample.data.repository

import com.atakan.firebaseexample.data.remote.RickApi
import com.atakan.firebaseexample.data.remote.dto.RickDto
import com.atakan.firebaseexample.domain.repository.RickRepository
import javax.inject.Inject

class RickRepositoryImpl @Inject constructor(
    private val api: RickApi
): RickRepository{

    override suspend fun getRickInfo(): RickDto {
        return api.getRickInfo()
    }
}