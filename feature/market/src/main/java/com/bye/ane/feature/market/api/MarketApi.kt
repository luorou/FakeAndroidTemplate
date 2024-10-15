package com.bye.ane.feature.market.api

import com.bye.ane.core.global.RespWrapper
import com.bye.ane.feature.market.data.CoinKLineResp
import retrofit2.http.GET
import retrofit2.http.QueryMap

interface MarketApi {

    @GET("/quote-b-api/kline")
    suspend fun getKLineData(@QueryMap params: Map<String, @JvmSuppressWildcards Any?>): RespWrapper<CoinKLineResp>

}