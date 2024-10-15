package com.bye.ane.feature.market.present.vm

import android.net.Uri
import android.util.Log
import com.blankj.utilcode.util.GsonUtils
import com.bye.ane.feature.market.present.contract.CoinKLineEffect
import com.bye.ane.feature.market.present.contract.CoinKLineState
import com.bye.ane.feature.market.repository.MarketRepository
import com.bye.ane.shared.mvi.vm.OrbitVM
import dagger.hilt.android.lifecycle.HiltViewModel
import java.net.URLEncoder
import javax.inject.Inject

@HiltViewModel
class CoinKLineVM @Inject() constructor(
    private val repository: MarketRepository
) : OrbitVM<CoinKLineState, CoinKLineEffect>() {
    override fun initState(): CoinKLineState {
        return CoinKLineState()
    }

    /**
     *
     */
    fun fetch(type: String) = intent {
        //{"trace" : "java_http_test1","data" :
        // {"code" : "700.HK","kline_type" : 1,"kline_timestamp_end" : 0,"query_kline_num" : 2,"adjust_type": 0}}
        val data = mapOf(
            "code" to type,
            "kline_type" to 1,
            "kline_timestamp_end" to System.currentTimeMillis(),
            "query_kline_num" to 2,
            "adjust_type" to 0
        )
        val query = mapOf(
            "trace" to "3baaa938-f92c-4a74-a228-fd49d5e2f8bc-1678419657806",
            "data" to data
        )
        Log.e("TAG", "fetch params: $query")
        val params = mapOf(
            "token" to "a1fa0a42cc0fcc0a5426e5639ff8ef20-c-app",
            "query" to GsonUtils.toJson(query),
        )
        Log.e("TAG", "fetch params: $params")
        //
        val resp = repository.getCoinList(params)
    }
}