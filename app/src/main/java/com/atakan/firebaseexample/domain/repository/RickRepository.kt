package com.atakan.firebaseexample.domain.repository

import com.atakan.firebaseexample.data.remote.dto.RickDto

interface RickRepository {

    suspend fun getRickInfo(): RickDto
}