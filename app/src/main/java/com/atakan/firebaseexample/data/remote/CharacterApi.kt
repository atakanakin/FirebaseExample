package com.atakan.firebaseexample.data.remote

import com.atakan.firebaseexample.common.Constants.ENDPOINT
import com.atakan.firebaseexample.data.remote.dto.AllDto
import com.atakan.firebaseexample.data.remote.dto.CharacterDto
import retrofit2.http.GET

interface CharacterApi {
    @GET(ENDPOINT)
    suspend fun getCharacterInfo(): AllDto
}