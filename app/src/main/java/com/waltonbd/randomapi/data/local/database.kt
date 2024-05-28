package com.waltonbd.randomapi.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.waltonbd.randomapi.data.local.dao.ProductDao
import com.waltonbd.randomapi.data.local.entity.ProductEntity

/**
 * Created by Ahsan Habib on 5/26/2024.
 */
@Database(
    entities = [ProductEntity::class],
    version = 1
)
abstract class LocalDatabase : RoomDatabase() {
    abstract val dao: ProductDao

    companion object {
        const val DATABASE_NAME = "random_api_db"
    }
}