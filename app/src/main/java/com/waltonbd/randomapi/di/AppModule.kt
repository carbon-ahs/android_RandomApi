package com.waltonbd.randomapi.di


import android.app.Application
import androidx.room.Room
import com.waltonbd.randomapi.data.local.LocalDatabase
import com.waltonbd.randomapi.data.remote.api.EComSiteApi
import com.waltonbd.randomapi.data.remote.api.RickMortyApi
import com.waltonbd.randomapi.data.repository.EComSiteRepositoryImpl
import com.waltonbd.randomapi.data.repository.RickMortyRepositoryImpl
import com.waltonbd.randomapi.domain.repository.EComSiteRepository
import com.waltonbd.randomapi.domain.repository.RickMortyRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import javax.inject.Singleton


/**
 * Created by Ahsan Habib on 5/21/2024.
 * ict.wsd19@waltonplc.com
 */
@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    @Provides
    @Singleton
    fun provideDatabase(
        app: Application,
    ): LocalDatabase {
        return Room.databaseBuilder(
            app,
            LocalDatabase::class.java,
            LocalDatabase.DATABASE_NAME
        ).build()
    }

    @Provides
    @Singleton
    fun provideEComSiteApi(): EComSiteApi {
        return Retrofit.Builder()
            .baseUrl(EComSiteApi.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(EComSiteApi::class.java)
    }

    @Provides
    @Singleton
    fun provideEComSiteRepository(
        api: EComSiteApi,
        db: LocalDatabase): EComSiteRepository {
        return EComSiteRepositoryImpl(api, db)
    }

    @Provides
    @Singleton
    fun provideRickMortyRepository(api: RickMortyApi): RickMortyRepository {
        return RickMortyRepositoryImpl(api)
    }

    @Provides
    @Singleton
    fun provideRickMortyApi(): RickMortyApi {
        return Retrofit.Builder()
            .baseUrl(RickMortyApi.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(RickMortyApi::class.java)
    }
}