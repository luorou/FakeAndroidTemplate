package com.bye.ane.feature.market.present.vm

import com.bye.ane.feature.market.present.contract.MarketEffect
import com.bye.ane.feature.market.present.contract.MarketState
import com.bye.ane.feature.market.repository.MarketRepository
import com.bye.ane.shared.mvi.vm.OrbitVM
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MarketVM @Inject constructor(
    private val repository: MarketRepository
) : OrbitVM<MarketState, MarketEffect>() {
    override fun initState(): MarketState {
        return MarketState()
    }


    fun buildListData(): MutableList<String> {
        return mutableListOf(
            "AAVE/USDT",
            "ADA/USDT",
            "ALGO/USDT",
            "APE/USDT",
            "ATOM/USDT",
            "AVAX/USDT",
            "AXS/USDT",
            "BCH/USDT",
            "BNB/USDT",
            "BTC/USDT"
        )
    }
}