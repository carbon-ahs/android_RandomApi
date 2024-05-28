package com.waltonbd.randomapi.data.remote.dto.rickMortyApiDto

import com.waltonbd.randomapi.domain.model.Character

data class CharacterApiDto(
    val results: List<Result>
)

fun CharacterApiDto.toCharacterList(): List<Character> {
    var characterList = emptyList<Character>()
    for (charecter in results) {
        characterList = characterList + charecter.toCharacter()
    }
    return characterList
}