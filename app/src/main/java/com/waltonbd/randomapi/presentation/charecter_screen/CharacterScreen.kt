package com.waltonbd.randomapi.presentation.charecter_screen

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.compose.material3.CircularProgressIndicator

/**
 * Created by Ahsan Habib on 5/28/2024.
 */
@Composable
fun CharacterScreen(
    modifier: Modifier = Modifier,
    viewModel: CharacterViewModel = hiltViewModel(),
) {
    val state = viewModel.state.value
    Scaffold { innerPadaing ->

        Box {
            if (state.isLoading) {
                CircularProgressIndicator()
            } else {
                Column(
                    modifier = modifier
                        .fillMaxSize()
                        .padding(innerPadaing)
                ) {
                    Text(text = state.characters?.get(1).toString())
                    LazyColumn(
                        modifier = Modifier.fillMaxSize()
                    ) {
                        item {
                            Text("Hlw")
                        }

                        items(state.characters) { character ->
                            Text(text = character.toString())
                        }


                    }
                }
            }
        }

    }

}