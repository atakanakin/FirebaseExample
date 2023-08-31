package com.atakan.firebaseexample.data.remote

import com.atakan.firebaseexample.common.Constants.ENDPOINT
import com.atakan.firebaseexample.data.remote.dto.RickDto
import retrofit2.http.GET

interface RickApi {
    @GET(ENDPOINT)
    suspend fun getRickInfo(): RickDto
}