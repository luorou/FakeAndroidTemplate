package com.bye.ane.core.network.di

import com.bye.ane.core.environment.EnvProvider
import com.bye.ane.core.network.interceptor.HeaderInterceptor
import com.safframework.http.interceptor.AndroidLoggingInterceptor
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Named
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetWorkModule {

    @Provides
    @Singleton
    fun provideOkHttpClient(
        @Named("loggingInterceptor") loggingInterceptor: Interceptor,
        @Named("headerInterceptor") headerInterceptor: Interceptor
    ): OkHttpClient {
        return OkHttpClient.Builder()
            .connectTimeout(30, TimeUnit.SECONDS)
            .readTimeout(30, TimeUnit.SECONDS)
            .writeTimeout(30, TimeUnit.SECONDS)
            .addInterceptor(headerInterceptor)
            .addInterceptor(loggingInterceptor)
            .build()
    }

    @Singleton
    @Provides
    @Named("loggingInterceptor")
    fun loggingInterceptor(): Interceptor =
        AndroidLoggingInterceptor.build(
            isDebug = true,
            hideVerticalLine = true
        )


    @Singleton
    @Provides
    @Named("headerInterceptor")
    fun headerInterceptor(): Interceptor = HeaderInterceptor()

    @Singleton
    @Provides
    fun provideRetrofit(okHttpClient: OkHttpClient): Retrofit = Retrofit.Builder()
        .addConverterFactory(GsonConverterFactory.create())
        .baseUrl(EnvProvider.domainUrl())
        .client(okHttpClient)
        .build()


}