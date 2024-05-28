package com.waltonbd.randomapi.domain.repository

import com.waltonbd.randomapi.data.remote.dto.rickMortyApiDto.CharacterApiDto
import com.waltonbd.randomapi.domain.model.Character


/**
 * Created by Ahsan Habib on 5/28/2024.
 */
interface RickMortyRepository {
    suspend fun getCharacters() : CharacterApiDto
    suspend fun getCharacterList() : List<Character>
}