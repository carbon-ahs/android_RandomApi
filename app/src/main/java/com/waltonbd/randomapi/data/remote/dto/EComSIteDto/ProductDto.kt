package com.waltonbd.randomapi.data.remote.dto.EComSIteDto

import com.waltonbd.randomapi.domain.model.Product

data class ProductDto(
    val id: Int,
    val product_name: String
)

fun ProductDto.toProduct(): Product {
    return Product(
        id = id,
        name = product_name
    )
}