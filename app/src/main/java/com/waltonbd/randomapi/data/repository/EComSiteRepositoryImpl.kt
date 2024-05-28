package com.waltonbd.randomapi.data.repository

import com.waltonbd.randomapi.data.local.LocalDatabase
import com.waltonbd.randomapi.data.local.entity.ProductEntity
import com.waltonbd.randomapi.data.remote.api.EComSiteApi
import com.waltonbd.randomapi.data.remote.dto.EComSIteDto.CategoryApiDto
import com.waltonbd.randomapi.data.remote.dto.EComSIteDto.ProductsByCategoryApiDto
import com.waltonbd.randomapi.data.remote.dto.EComSIteDto.toCategoryList
import com.waltonbd.randomapi.data.remote.dto.EComSIteDto.toProductList
import com.waltonbd.randomapi.domain.model.Category
import com.waltonbd.randomapi.domain.model.Product
import com.waltonbd.randomapi.domain.repository.EComSiteRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject


/**
 * Created by Ahsan Habib on 5/27/2024.
 */
class EComSiteRepositoryImpl @Inject constructor(
    private val api: EComSiteApi,
    private val db: LocalDatabase
) : EComSiteRepository{
    override suspend fun getCategories(): List<Category> {
        var apiObj = api.getCategories()
        var categoryList = apiObj.toCategoryList()
        return categoryList
    }

    override suspend fun getProductsByCategoryId(categoryId: String): List<Product> {
        var apiObj = api.getProductsByCategoryId(categoryId)
        var productList = apiObj.toProductList()
        return productList
    }

    override fun getProducts(): Flow<List<ProductEntity>> {
        return db.dao.getAllProducts()
    }

    override suspend fun insertProduct(product: ProductEntity) {
        db.dao.insertProduct(product)
    }

    override suspend fun deleteProduct(product: ProductEntity) {
        db.dao.deleteProduct(product)
    }
}