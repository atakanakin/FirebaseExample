package com.atakan.firebaseexample.domain.use_case

import com.atakan.firebaseexample.common.Resource
import com.atakan.firebaseexample.domain.model.Character
import com.atakan.firebaseexample.data.remote.dto.toCharacter
import com.atakan.firebaseexample.domain.repository.CharacterRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetCharacterUseCase @Inject constructor(
    private val repository: CharacterRepository
){
    operator fun invoke(): Flow<Resource<Character>> = flow{
        try {
            emit(Resource.Loading())
            val character = repository.getCharacterInfo().toCharacter()
            emit(Resource.Success(character))
        } catch (e : HttpException){
            emit(Resource.Error(e.localizedMessage ?: "Unexpected error occurred."))
        } catch (e : IOException){
            emit(Resource.Error("Could not reach server. Check your connection."))
        }
    }
}