package com.waltonbd.randomapi.presentation.categories_screen

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.waltonbd.randomapi.common.Resource
import com.waltonbd.randomapi.domain.use_case.get_categories.GetCategoriesUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject


/**
 * Created by Ahsan Habib on 5/27/2024.
 */
@HiltViewModel
class CategoriesViewModel @Inject constructor(
    private val getCategoriesUseCase: GetCategoriesUseCase

) : ViewModel() {
    private val _state = mutableStateOf(CategoriesState())
    val state: State<CategoriesState> = _state

    init {
        getCategories()
    }

    private fun getCategories() {
        getCategoriesUseCase().onEach { result ->
            when(result) {
                is Resource.Error -> {
                    _state.value = CategoriesState(error = result.message ?: "Error")
                }
                is Resource.Loading -> {
                    _state.value = CategoriesState(isLoading = true)
                }
                is Resource.Success -> {
                    _state.value = CategoriesState(categories = result.data ?: emptyList())
                }
            }

        }.launchIn(viewModelScope)
    }
}