package com.hekr.shared.localstore

import com.bye.ane.shared.store.ILocalStore
import com.bye.ane.shared.store.StoreTypes
import com.bye.ane.shared.store.mmkv.MMKVStore
import com.bye.ane.shared.store.sp.SPStore


class StoreFactory {

    /**
     *
     */
    fun createStore(types: StoreTypes): ILocalStore {
        return when (types) {
            StoreTypes.MMKV -> {
                MMKVStore()
            }
            StoreTypes.SP -> {
                SPStore()
            }
            else -> {
                MMKVStore()
            }
        }
    }
}