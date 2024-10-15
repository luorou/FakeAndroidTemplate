package com.bye.ane.feature.market.present.ui.page

import android.os.Bundle
import android.view.View
import androidx.activity.viewModels
import com.bye.ane.core.global.PageParams
import com.bye.ane.feature.market.databinding.MarketCoinKLineActivityBinding
import com.bye.ane.feature.market.port.RouterPaths
import com.bye.ane.feature.market.present.contract.CoinKLineEffect
import com.bye.ane.feature.market.present.contract.CoinKLineState
import com.bye.ane.feature.market.present.vm.CoinKLineVM
import com.bye.ane.shared.mvi.ui.activity.OrbitMviActivity
import com.didi.drouter.annotation.Router
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
@Router(path = RouterPaths.COIN_KLINE_PAGE)
class CoinKLineActivity : OrbitMviActivity<
        CoinKLineState,
        CoinKLineEffect,
        CoinKLineVM,
        MarketCoinKLineActivityBinding
        >() {


    override val VM: CoinKLineVM by viewModels()

    override fun initVBAndGetRootView(): View {
        this.mBind = MarketCoinKLineActivityBinding.inflate(layoutInflater)
        return mBind.root
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val type = intent.getStringExtra(PageParams.TYPE)
        VM.fetch(type!!)
    }

    override fun renderWithState(state: CoinKLineState) {
    }

    override fun renderWithEffect(eff: CoinKLineEffect) {
    }

}