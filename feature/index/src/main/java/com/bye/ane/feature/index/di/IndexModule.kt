package com.bye.ane.feature.index.di

import com.bye.ane.feature.index.api.IndexApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object IndexModule {

    @Provides
    @Singleton
    fun provideIndexApi(retrofit: Retrofit): IndexApi {
        return retrofit.create(IndexApi::class.java)
    }
}