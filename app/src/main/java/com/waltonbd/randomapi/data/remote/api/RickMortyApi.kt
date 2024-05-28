package com.waltonbd.randomapi.data.remote.api

import com.waltonbd.randomapi.data.remote.dto.rickMortyApiDto.CharacterApiDto
import retrofit2.http.GET


/**
 * Created by Ahsan Habib on 5/28/2024.
 */
interface RickMortyApi {
    @GET("character")
    suspend fun getCharacter() : CharacterApiDto

    companion object {
        const val BASE_URL = "https://rickandmortyapi.com/api/"
    }
}