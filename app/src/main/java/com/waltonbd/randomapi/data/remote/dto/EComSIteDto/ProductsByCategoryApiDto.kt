package com.waltonbd.randomapi.data.remote.dto.EComSIteDto

import com.waltonbd.randomapi.domain.model.Category
import com.waltonbd.randomapi.domain.model.Product

data class ProductsByCategoryApiDto(
    val `data`: List<ProductDto>,
)

fun ProductsByCategoryApiDto.toProductList() : List<Product>{
    val productDtoList = data

    var listOfProduct = emptyList<Product>()

    for (productDto in productDtoList){
        listOfProduct = listOfProduct + productDto.toProduct()
    }

    return listOfProduct

}