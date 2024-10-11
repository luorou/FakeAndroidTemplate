package com.bye.ane.core.environment

object EnvProvider {
    private val envType: EnvType = EnvType.DEBUG
    //
    private val buildType: BuildType = BuildType.DEBUG


    @Synchronized
    fun isDebug(): Boolean {
        return buildType == BuildType.DEBUG
    }

    @Synchronized
    fun domainUrl(): String {
        return "https://google.cn"
    }

    fun initBuildType(type: BuildType) {

    }
}