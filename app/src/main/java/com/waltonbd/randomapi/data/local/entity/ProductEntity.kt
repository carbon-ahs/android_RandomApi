package com.waltonbd.randomapi.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey


/**
 * Created by Ahsan Habib on 5/28/2024.
 */
@Entity(tableName = "product_table")
data class ProductEntity(
    @PrimaryKey
    val id: Int,
    val name: String,
    val categoryName: String
)
