package com.bye.ane.feature.market.present.ui.slice

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.bye.ane.feature.market.databinding.MarketIndexFragmentBinding
import com.bye.ane.feature.market.present.contract.MarketEffect
import com.bye.ane.feature.market.present.contract.MarketState
import com.bye.ane.feature.market.present.ui.adapter.CoinListAdapter
import com.bye.ane.feature.market.present.vm.MarketVM
import com.bye.ane.shared.mvi.ui.frgment.OrbitMviFragment
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class MarketFragment :
    OrbitMviFragment<MarketState, MarketEffect, MarketVM, MarketIndexFragmentBinding>() {


    override val VM: MarketVM by viewModels()

    override fun initVBAndGetRootView(layoutInflater: LayoutInflater): View {
        this.mBind = MarketIndexFragmentBinding.inflate(layoutInflater)
        return mBind.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView()
        initData()
        initListener()
    }


    /**
     *
     */
    private fun initView() {
        mBind.rv.layoutManager = LinearLayoutManager(requireContext())

    }

    /**
     *
     */
    private fun initData() {
        val data = VM.buildListData()
        mBind.rv.adapter = CoinListAdapter(data)
    }

    /**
     *
     */
    private fun initListener() {

    }

    override fun renderWithState(state: MarketState) {

    }

    override fun renderWithEffect(eff: MarketEffect) {
    }
}