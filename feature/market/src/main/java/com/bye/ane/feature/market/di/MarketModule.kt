package com.bye.ane.feature.market.di

import com.bye.ane.feature.market.api.MarketApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object MarketModule {

    @Provides
    @Singleton
    fun provideMarketApi(retrofit: Retrofit): MarketApi {
        return retrofit.create(MarketApi::class.java)
    }
}