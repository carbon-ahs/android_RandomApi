package com.waltonbd.randomapi.data.repository

import com.waltonbd.randomapi.data.remote.api.RickMortyApi
import com.waltonbd.randomapi.data.remote.dto.rickMortyApiDto.CharacterApiDto
import com.waltonbd.randomapi.data.remote.dto.rickMortyApiDto.toCharacterList
import com.waltonbd.randomapi.domain.model.Character
import com.waltonbd.randomapi.domain.repository.RickMortyRepository
import javax.inject.Inject


/**
 * Created by Ahsan Habib on 5/28/2024.
 */
class RickMortyRepositoryImpl @Inject constructor(
    private val api: RickMortyApi
): RickMortyRepository {
    override suspend fun getCharacters(): CharacterApiDto {
        return api.getCharacter()
    }

    override suspend fun getCharacterList(): List<Character> {
        return getCharacters().toCharacterList()
    }


}
