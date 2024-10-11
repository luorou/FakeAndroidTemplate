package com.bye.ane.core.environment

import android.content.Context
import com.bye.ane.shared.store.LocalStore
import com.bye.ane.shared.store.StoreTypes

object EnvProvider {
    //
    private var envType: EnvType = EnvType.RELEASE

    //
    private var buildType: BuildType = BuildType.RELEASE

    /**
     *
     */
    @Synchronized
    fun isRelease(): Boolean {
        return buildType == BuildType.RELEASE
    }

    /**
     * 初始化 buildType
     */
    @Synchronized
    fun initBuildType(type: BuildType) {
        buildType = type
    }

    /**
     *
     */
    @Synchronized
    fun getBuildType(): BuildType {
        return buildType
    }

    /**
     * 初始化 envType
     */
    @Synchronized
    fun initEnvType(ctx: Context, type: EnvType) {
        envType = type
        LocalStore.get(ctx, StoreTypes.MMKV).saveString(EnvStoreKeys.STORE_KEY_ENV_TYPE, type.name)
    }

    /**
     *
     */
    @Synchronized
    fun getEnvType(): EnvType {
        return envType
    }

    @Synchronized
    fun resetEnvType(ctx: Context, type: EnvType) {
        envType = type
        LocalStore.get(ctx, StoreTypes.MMKV).saveString(EnvStoreKeys.STORE_KEY_ENV_TYPE, type.name)
    }

    /**
     *
     */
    @Synchronized
    fun domainUrl(): String {
        //
        return when (envType) {
            EnvType.DEBUG -> {
                UrlConfig.DEBUG_DOMAIN_URL
            }

            EnvType.STAGING -> {
                UrlConfig.STAGING_DOMAIN_URL
            }

            EnvType.RELEASE -> {
                UrlConfig.RELEASE_DOMAIN_URL
            }

            else -> {
                UrlConfig.RELEASE_DOMAIN_URL
            }
        }
    }

}