package com.bye.ane.feature.login.repository

import com.bye.ane.feature.login.api.LoginApi
import com.bye.ane.feature.login.port.repository.LoginExposeRepository
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class LoginExposeRepositoryImpl @Inject constructor(private val api: LoginApi) :
    LoginExposeRepository {
    override fun login(): String {
        return "api.login()"
    }
}