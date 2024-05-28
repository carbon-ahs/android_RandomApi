package com.waltonbd.randomapi.domain.repository

import com.waltonbd.randomapi.data.local.entity.ProductEntity
import com.waltonbd.randomapi.data.remote.dto.EComSIteDto.CategoryApiDto
import com.waltonbd.randomapi.data.remote.dto.EComSIteDto.ProductsByCategoryApiDto
import com.waltonbd.randomapi.domain.model.Category
import com.waltonbd.randomapi.domain.model.Product
import kotlinx.coroutines.flow.Flow


/**
 * Created by Ahsan Habib on 5/27/2024.
 */
interface EComSiteRepository {
    suspend fun getCategories(): List<Category>
    suspend fun getProductsByCategoryId(categoryId: String) : List<Product>

    fun getProducts() : Flow<List<ProductEntity>>
    suspend fun insertProduct(product: ProductEntity)
    suspend fun deleteProduct(product: ProductEntity)
}