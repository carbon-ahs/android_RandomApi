package com.waltonbd.randomapi.presentation.categories_screen

import com.waltonbd.randomapi.data.remote.dto.EComSIteDto.CategoryApiDto
import com.waltonbd.randomapi.domain.model.Category


/**
 * Created by Ahsan Habib on 5/27/2024.
 */
data class CategoriesState(
    val isLoading: Boolean = false,
    val categories: List<Category> = emptyList(),
    val error: String = ""
)
