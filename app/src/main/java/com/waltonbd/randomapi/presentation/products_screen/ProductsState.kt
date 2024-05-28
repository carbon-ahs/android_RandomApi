package com.waltonbd.randomapi.presentation.products_screen

import com.waltonbd.randomapi.data.remote.dto.EComSIteDto.CategoryApiDto
import com.waltonbd.randomapi.domain.model.Category
import com.waltonbd.randomapi.domain.model.Product


/**
 * Created by Ahsan Habib on 5/27/2024.
 */
data class ProductsState(
    val isLoading: Boolean = false,
    val products: List<Product> = emptyList(),
    val error: String = ""
)
