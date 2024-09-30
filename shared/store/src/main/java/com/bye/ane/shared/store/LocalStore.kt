package com.bye.ane.shared.store

import android.content.Context
import com.hekr.shared.localstore.StoreFactory

object LocalStore {
    //
    private var mSPStore: ILocalStore? = null

    //
    private var mMMKVStore: ILocalStore? = null

    /**
     *
     */
    fun initialize(ctx: Context) {
        mMMKVStore = StoreFactory().createStore(StoreTypes.MMKV)
        mMMKVStore?.globalInitialize(ctx)
        mSPStore = StoreFactory().createStore(StoreTypes.SP)
        mSPStore?.globalInitialize(ctx)
    }

    /**
     *
     */
    fun get(ctx: Context, types: StoreTypes): ILocalStore {
        return when (types) {
            StoreTypes.MMKV -> {
                createMmkvInstance(ctx)
            }

            StoreTypes.SP -> {
                createSpInstance(ctx)
            }
            else -> {
                createMmkvInstance(ctx)
            }
        }
    }

    /**
     *
     */
    private fun createSpInstance(ctx: Context): ILocalStore {
        if (mMMKVStore == null) {
            mSPStore = StoreFactory().createStore(StoreTypes.SP)
            mSPStore?.globalInitialize(ctx)
        }
        return mSPStore!!
    }

    /**
     *
     */
    private fun createMmkvInstance(ctx: Context): ILocalStore {
        if (mMMKVStore == null) {
            mMMKVStore = StoreFactory().createStore(StoreTypes.MMKV)
            mMMKVStore?.globalInitialize(ctx)
        }
        return mMMKVStore!!
    }

}