//package com.waltonbd.randomapi.di
//
//
//import android.app.Application
//import androidx.room.Room
//import dagger.Module
//import dagger.Provides
//import dagger.hilt.InstallIn
//import dagger.hilt.components.SingletonComponent
//import javax.inject.Singleton
//
//
///**
// * Created by Ahsan Habib on 5/21/2024.
// * ict.wsd19@waltonplc.com
// */
//@Module
//@InstallIn(SingletonComponent::class)
//object AppModule {
//    @Provides
//    @Singleton
//    fun provideDatabase(
//        app: Application
//    ): LocalDatabase {
//        return Room.databaseBuilder(
//            app,
//            LocalDatabase::class.java,
//            LocalDatabase.DATABASE_NAME
//        ).build()
//    }
//
//}