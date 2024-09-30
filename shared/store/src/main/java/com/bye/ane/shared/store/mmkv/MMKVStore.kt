package com.bye.ane.shared.store.mmkv

import android.content.Context
import com.bye.ane.shared.store.ILocalStore
import com.tencent.mmkv.MMKV

class MMKVStore : ILocalStore {

    private var mmkv: MMKV? = null

    override fun globalInitialize(ctx: Context) {
        MMKV.initialize(ctx)
        mmkv = MMKV.defaultMMKV()
    }

    override fun saveString(key: String, value: String) {
        kotlin.runCatching {
            mmkv?.encode(key, value)
        }.onSuccess {
        }.onFailure {
        }

    }

    override fun getString(key: String): String? {
        var result: String? = ""
        kotlin.runCatching {
            mmkv?.decodeString(key)
        }.onSuccess {
            result = it
        }.onFailure {
            result = null
        }

        return result
    }

    override fun saveInt(key: String, value: Int) {
        kotlin.runCatching {
            mmkv?.encode(key, value)
        }.onSuccess {

        }.onFailure {

        }

    }

    override fun getInt(key: String): Int? {
        var result: Int? = null
        kotlin.runCatching {
            mmkv?.decodeInt(key)
        }.onSuccess {
            result = it
        }.onFailure {
            result = null
        }
        return result
    }

    override fun saveLong(key: String, value: Long) {
        kotlin.runCatching {
            mmkv?.encode(key, value)
        }.onSuccess {

        }.onFailure {

        }

    }

    override fun getLong(key: String): Long? {
        var result: Long? = null
        kotlin.runCatching {
            mmkv?.decodeLong(key)
        }.onSuccess {
            result = it
        }.onFailure {
            result = null
        }
        return result
    }

    override fun saveDouble(key: String, value: Double) {
        kotlin.runCatching {
            mmkv?.encode(key, value)
        }.onSuccess {

        }.onFailure {

        }

    }

    override fun getDouble(key: String): Double? {
        var result: Double? = null
        kotlin.runCatching {
            mmkv?.decodeDouble(key)
        }.onSuccess {
            result = it
        }.onFailure {
            result = null
        }
        return result
    }

    override fun saveBoolean(key: String, value: Boolean) {
        kotlin.runCatching {
            mmkv?.encode(key, value)
        }.onSuccess {

        }.onFailure {

        }

    }

    override fun getBoolean(key: String): Boolean? {
        var result: Boolean? = false
        kotlin.runCatching {
            mmkv?.decodeBool(key)
        }.onSuccess {
            result = it
        }.onFailure {
            result = null
        }
        return result
    }

    override fun remove(key: String) {
        kotlin.runCatching {
            mmkv?.remove(key)
        }.onSuccess {

        }.onFailure {

        }

    }
}