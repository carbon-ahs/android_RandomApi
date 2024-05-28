package com.waltonbd.randomapi.data.remote.dto.EComSIteDto

import com.google.gson.annotations.SerializedName
import com.waltonbd.randomapi.domain.model.Category

data class CategoryDto(
    @SerializedName("category_name")
    val categoryName: String,
    val id: Int
)

fun CategoryDto.toCategory(): Category {
    return Category(
        id = id,
        name = categoryName
    )
}