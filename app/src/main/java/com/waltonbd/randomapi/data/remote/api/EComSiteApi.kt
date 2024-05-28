package com.waltonbd.randomapi.data.remote.api

import com.waltonbd.randomapi.data.remote.dto.EComSIteDto.CategoryApiDto
import com.waltonbd.randomapi.data.remote.dto.EComSIteDto.ProductsByCategoryApiDto
import retrofit2.http.GET
import retrofit2.http.Path


/**
 * Created by Ahsan Habib on 5/27/2024.
 */
interface EComSiteApi {
    @GET("get-categories")
    suspend fun getCategories() : CategoryApiDto

    @GET("product-by-category/{categoryId}")
    suspend fun getProductsByCategoryId(@Path("categoryId") categoryId: String) : ProductsByCategoryApiDto

    companion object {
        const val BASE_URL = "https://e-unionint.com/api/"
    }
}