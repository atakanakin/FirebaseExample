package com.atakan.firebaseexample.domain.use_case

import com.atakan.firebaseexample.common.Resource
import com.atakan.firebaseexample.data.remote.dto.toRick
import com.atakan.firebaseexample.domain.model.Rick
import com.atakan.firebaseexample.domain.repository.RickRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetRickUseCase @Inject constructor(
    private val repository: RickRepository
){
    operator fun invoke(): Flow<Resource<Rick>> = flow{
        try {
            emit(Resource.Loading())
            val rick = repository.getRickInfo().toRick()
            emit(Resource.Success(rick))
        } catch (e : HttpException){
            emit(Resource.Error(e.localizedMessage ?: "Unexpected error occurred."))
        } catch (e : IOException){
            emit(Resource.Error("Could not reach server. Check your connection."))
        }
    }
}