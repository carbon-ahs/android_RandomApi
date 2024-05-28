package com.waltonbd.randomapi.data.local.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.waltonbd.randomapi.data.local.entity.ProductEntity
import kotlinx.coroutines.flow.Flow


/**
 * Created by Ahsan Habib on 5/28/2024.
 */
@Dao
interface ProductDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertProduct(productEntity: ProductEntity)

    @Delete
    fun deleteProduct(productEntity: ProductEntity)

    @Query("SELECT * FROM product_table")
    fun getAllProducts(): Flow<List<ProductEntity>>
}