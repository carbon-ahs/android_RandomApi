package com.waltonbd.randomapi.presentation.charecter_screen

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.waltonbd.randomapi.common.Resource
import com.waltonbd.randomapi.domain.use_case.get_charecter.GetCharacterListUseCase
import com.waltonbd.randomapi.presentation.categories_screen.CategoriesState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject


/**
 * Created by Ahsan Habib on 5/28/2024.
 */
@HiltViewModel
class CharacterViewModel @Inject constructor(
    private val getCharacterListUseCase: GetCharacterListUseCase

) : ViewModel() {
    private val _state = mutableStateOf(CharacterListState())
    val state: State<CharacterListState> = _state

    init {
        getCharacterList()
    }

    private fun getCharacterList() {
        getCharacterListUseCase().onEach { result ->
            when(result) {
                is Resource.Error -> {
                    _state.value = CharacterListState(error = result.message ?: "Error")
                }
                is Resource.Loading -> {
                    _state.value = CharacterListState(isLoading = true)
                }
                is Resource.Success -> {
                    _state.value = CharacterListState(characters = result.data ?: emptyList())
                }
            }

        }.launchIn(viewModelScope)
    }
}