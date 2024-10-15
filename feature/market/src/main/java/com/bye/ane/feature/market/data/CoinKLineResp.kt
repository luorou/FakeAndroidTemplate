package com.bye.ane.feature.market.data

data class CoinKLineResp(
    val code: String,
    val data: List<CoinKLinePO>
)

data class CoinKLinePO(
    val timestamp: String,
    val open_price: String,
    val close_price: String,
    val high_price: String,
    val low_price: String,
    val volume: String,
    val turnover: String
)