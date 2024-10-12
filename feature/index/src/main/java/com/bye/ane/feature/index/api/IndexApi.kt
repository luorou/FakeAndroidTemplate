package com.bye.ane.feature.index.api

import com.bye.ane.core.global.RespWrapper
import retrofit2.http.GET

interface IndexApi {


    @GET("/")
    suspend fun login(): RespWrapper<String>
}