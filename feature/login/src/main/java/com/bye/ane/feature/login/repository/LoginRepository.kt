package com.bye.ane.feature.login.repository

import com.bye.ane.feature.login.api.LoginApi
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class LoginRepository @Inject constructor(private val api: LoginApi) {
    fun login(): String {
        return "api.login()"
    }
}