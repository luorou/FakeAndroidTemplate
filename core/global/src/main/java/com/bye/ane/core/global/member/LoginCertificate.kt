package com.bye.ane.core.global.member

import android.content.Context
import com.blankj.utilcode.util.GsonUtils
import com.bye.ane.core.global.GlobalStoreKeys
import com.bye.ane.shared.store.LocalStore
import com.bye.ane.shared.store.StoreTypes

class LoginCertificate {
    private var token: String? = null
    private var refreshToken: String? = null
    private var expireTime: Long = 0


    fun getToken(): String? {
        return token
    }

    /**
     *
     */
    fun cache(ctx: Context) {
        //
        LocalStore.get(ctx, StoreTypes.MMKV)
            .saveString(GlobalStoreKeys.STORE_KEY_LOGIN_CERTIFICATE, GsonUtils.toJson(this))

    }

    /**
     *
     */
    fun clear(ctx: Context) {
        LocalStore.get(ctx, StoreTypes.MMKV).remove(GlobalStoreKeys.STORE_KEY_LOGIN_CERTIFICATE)
    }

    /**
     *
     */
    fun getCache(ctx: Context): LoginCertificate? {
        val cache = LocalStore.get(ctx, StoreTypes.MMKV)
            .getString(GlobalStoreKeys.STORE_KEY_LOGIN_CERTIFICATE)
        //
        if (cache.isNullOrEmpty()) {
            return null
        }
        //
        kotlin.runCatching {
            GsonUtils.fromJson(cache, LoginCertificate::class.java)
        }.onSuccess {
            return it
        }
        return null
    }
}