package com.bye.ane.feature.market.present.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bye.ane.core.global.PageParams
import com.bye.ane.feature.market.databinding.MarketCoinListAdapterBinding
import com.bye.ane.feature.market.port.RouterPaths
import com.didi.drouter.api.DRouter

class CoinListAdapter(val coins: MutableList<String>) :
    RecyclerView.Adapter<CoinListAdapter.ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding =
            MarketCoinListAdapterBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val coin = coins[position]
        holder.binding.tvCoin.text = coin
        holder.binding.root.setOnClickListener {
            DRouter.build(RouterPaths.COIN_KLINE_PAGE)
                .putExtra(PageParams.TYPE, coin.replace("/", ""))
                .start(holder.binding.tvCoin.context)
        }
    }

    override fun getItemCount(): Int {
        return coins.size
    }


    class ViewHolder(val binding: MarketCoinListAdapterBinding) :
        RecyclerView.ViewHolder(binding.root) {}
}