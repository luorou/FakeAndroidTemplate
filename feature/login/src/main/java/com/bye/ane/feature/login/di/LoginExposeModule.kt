package com.bye.ane.feature.login.di

import com.bye.ane.feature.login.port.repository.LoginExposeRepository
import com.bye.ane.feature.login.repository.LoginExposeRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class LoginExposeModule {
    @Binds
    @Singleton
   abstract fun bindLoginRepository(impl: LoginExposeRepositoryImpl): LoginExposeRepository

}