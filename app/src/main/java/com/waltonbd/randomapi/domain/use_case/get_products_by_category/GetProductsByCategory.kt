package com.waltonbd.randomapi.domain.use_case.get_products_by_category

import com.waltonbd.randomapi.common.Resource
import com.waltonbd.randomapi.domain.model.Category
import com.waltonbd.randomapi.domain.model.Product
import com.waltonbd.randomapi.domain.repository.EComSiteRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject


/**
 * Created by Ahsan Habib on 5/28/2024.
 */
class GetProductsByCategory @Inject constructor(
    private val repository: EComSiteRepository
) {
    operator fun invoke(categoryId : String): Flow<Resource<List<Product>>> = flow {
        try {
            emit(Resource.Loading())
            val products = repository.getProductsByCategoryId(categoryId) //.map {  }
            emit(Resource.Success(products))
        } catch(e: HttpException) {
            emit(Resource.Error(e.localizedMessage ?: "An unexpected error occured"))
        } catch(e: IOException) {
            emit(Resource.Error("Couldn't reach server. Check your internet connection."))
        }
    }
}