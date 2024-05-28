package com.waltonbd.randomapi.domain.model


/**
 * Created by Ahsan Habib on 5/28/2024.
 */
data class Character(
    val created: String,
    val gender: String,
    val id: Int,
    val image: String,
    val name: String,
    val species: String,
    val status: String,
    val url: String
)
