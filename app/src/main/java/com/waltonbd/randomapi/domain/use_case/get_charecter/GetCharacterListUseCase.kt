package com.waltonbd.randomapi.domain.use_case.get_charecter

import com.waltonbd.randomapi.common.Resource
import com.waltonbd.randomapi.data.remote.dto.EComSIteDto.CategoryApiDto
import com.waltonbd.randomapi.domain.model.Character
import com.waltonbd.randomapi.domain.repository.RickMortyRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject


/**
 * Created by Ahsan Habib on 5/28/2024.
 */
class GetCharacterListUseCase @Inject constructor(
    private val repository: RickMortyRepository
) {
    operator fun invoke(): Flow<Resource<List<Character>>> = flow {
        try {
            emit(Resource.Loading())
            val characters = repository.getCharacterList() //.map {  }
            emit(Resource.Success(characters))
        } catch(e: HttpException) {
            emit(Resource.Error(e.localizedMessage ?: "An unexpected error occured"))
        } catch(e: IOException) {
            emit(Resource.Error("Couldn't reach server. Check your internet connection."))
        }
    }
}