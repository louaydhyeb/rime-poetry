package com.ldcoding.rime.di

import com.ldcoding.rime.common.Constants.BASE_URL
import com.ldcoding.rime.data.remote.PoetryApi
import com.ldcoding.rime.data.repository.PoemRepositoryImp
import com.ldcoding.rime.domain.repository.PoemRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun providePoemApi(): PoetryApi =
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(PoetryApi::class.java)

    @Provides
    @Singleton
    fun providePoemRepository(api: PoetryApi): PoemRepository =
        PoemRepositoryImp(api)
}