package com.waltonbd.randomapi.data.remote.dto.EComSIteDto

import com.waltonbd.randomapi.domain.model.Category

data class CategoryApiDto(
    val `data`: List<CategoryDto>,
)

fun CategoryApiDto.toCategoryList() : List<Category>{
    val categoryDtoList = data

    var listOfCategory = emptyList<Category>()

    for (categoryDto in categoryDtoList){
        listOfCategory = listOfCategory + categoryDto.toCategory()
    }

    return listOfCategory

}