package com.bye.ane.feature.market.repository

import android.util.Log
import com.bye.ane.core.cheaps.onFailureHandler
import com.bye.ane.core.network.fliter.RespFilter
import com.bye.ane.feature.market.api.MarketApi
import com.bye.ane.feature.market.data.CoinKLineResp
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class MarketRepository @Inject constructor(private val api: MarketApi) {

    /**
     *
     */
    suspend fun getCoinList(params: Map<String, Any?>): CoinKLineResp? {
        val filter = RespFilter.Builder<CoinKLineResp>()
        kotlin.runCatching {
            api.getKLineData(params)
        }.onSuccess {
            filter.setResponse(it)
        }.onFailure { e ->
            Log.e("TAG--", "${e.message}")
            filter.setException(e)
                .setFailureBlock {
                    onFailureHandler(e)
                }

        }
        return filter.build().process()
    }
}