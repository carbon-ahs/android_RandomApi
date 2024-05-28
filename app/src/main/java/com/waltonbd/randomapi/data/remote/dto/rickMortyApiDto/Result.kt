package com.waltonbd.randomapi.data.remote.dto.rickMortyApiDto

import com.waltonbd.randomapi.data.remote.dto.rickMortyApiDto.Result
import com.waltonbd.randomapi.domain.model.Character

data class Result(
    val created: String,
    val gender: String,
    val id: Int,
    val image: String,
    val name: String,
    val species: String,
    val status: String,
    val url: String
)

fun Result.toCharacter() : Character{
    return Character(
        created, gender, id, image, name, species, status, url
    )
}