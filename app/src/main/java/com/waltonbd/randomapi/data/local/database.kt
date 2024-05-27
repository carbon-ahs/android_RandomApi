package com.waltonbd.randomapi.data.local

import androidx.room.Database
import androidx.room.RoomDatabase

/**
 * Created by Ahsan Habib on 5/26/2024.
 */
//@Database(
//    entities = [::class],
//    version = 1
//)
abstract class LocalDatabase : RoomDatabase() {
//    abstract val dao: Dao

    companion object {
        const val DATABASE_NAME = "random_api_db"
    }
}