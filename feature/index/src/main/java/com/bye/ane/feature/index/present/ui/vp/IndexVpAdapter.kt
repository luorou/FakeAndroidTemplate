package com.bye.ane.feature.index.present.ui.vp

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.bye.ane.feature.market.present.ui.slice.MarketFragment

class IndexVpAdapter(fm: FragmentManager, lifecycle: Lifecycle) :
    FragmentStateAdapter(fm, lifecycle) {
    override fun getItemCount(): Int {
        return 4
    }

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> {
                MarketFragment()
            }

            1 -> {
                Fragment()
            }

            2 -> {
                Fragment()
            }

            else -> {
                Fragment()
            }
        }
    }
}