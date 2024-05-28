package com.waltonbd.randomapi.domain.use_case.get_categories

import com.waltonbd.randomapi.common.Resource
import com.waltonbd.randomapi.data.remote.dto.EComSIteDto.CategoryApiDto
import com.waltonbd.randomapi.domain.model.Category
import com.waltonbd.randomapi.domain.repository.EComSiteRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import okio.IOException
import retrofit2.HttpException
import javax.inject.Inject


/**
 * Created by Ahsan Habib on 5/27/2024.
 */
class GetCategoriesUseCase @Inject constructor(
    private val repository: EComSiteRepository
) {
    operator fun invoke(): Flow<Resource<List<Category>>> = flow {
        try {
            emit(Resource.Loading())
            val categories = repository.getCategories() //.map {  }
            emit(Resource.Success(categories))
        } catch(e: HttpException) {
            emit(Resource.Error(e.localizedMessage ?: "An unexpected error occured"))
        } catch(e: IOException) {
            emit(Resource.Error("Couldn't reach server. Check your internet connection."))
        }
    }
}