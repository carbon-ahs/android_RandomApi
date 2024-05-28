package com.waltonbd.randomapi.presentation.products_screen

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.waltonbd.randomapi.common.Resource
import com.waltonbd.randomapi.domain.use_case.get_categories.GetCategoriesUseCase
import com.waltonbd.randomapi.domain.use_case.get_products_by_category.GetProductsByCategory
import com.waltonbd.randomapi.presentation.categories_screen.CategoriesState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject


/**
 * Created by Ahsan Habib on 5/28/2024.
 */
@HiltViewModel
class ProductViewModel @Inject constructor(
    private val getProductsByCategory: GetProductsByCategory
) : ViewModel() {
    private val _state = mutableStateOf(ProductsState())
    val state: State<ProductsState> = _state

    init {
        getProducts()
    }

    private fun getProducts() {
        getProductsByCategory("5").onEach { result ->
            when(result) {
                is Resource.Error -> {
                    _state.value = ProductsState(error = result.message ?: "Error")
                }
                is Resource.Loading -> {
                    _state.value = ProductsState(isLoading = true)
                }
                is Resource.Success -> {
                    _state.value = ProductsState(products = result.data ?: emptyList())
                }
            }

        }.launchIn(viewModelScope)
    }
}