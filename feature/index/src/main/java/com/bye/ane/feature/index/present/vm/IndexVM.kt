package com.bye.ane.feature.index.present.vm

import com.bye.ane.feature.index.present.contract.IndexEffect
import com.bye.ane.feature.index.present.contract.IndexState
import com.bye.ane.shared.mvi.vm.OrbitVM

class IndexVM() : OrbitVM<IndexState, IndexEffect>() {
    override fun initState(): IndexState {
        return IndexState()
    }
}