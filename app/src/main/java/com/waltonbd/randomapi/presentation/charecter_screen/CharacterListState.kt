package com.waltonbd.randomapi.presentation.charecter_screen

import com.waltonbd.randomapi.data.remote.dto.EComSIteDto.CategoryApiDto
import com.waltonbd.randomapi.domain.model.Character


/**
 * Created by Ahsan Habib on 5/28/2024.
 */
data class CharacterListState(
    val isLoading: Boolean = false,
    val characters: List<Character> = emptyList(),
    val error: String = ""
)