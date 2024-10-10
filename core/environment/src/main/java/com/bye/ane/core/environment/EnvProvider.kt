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
        return ""
    }

    fun initBuildType(type: BuildType) {

    }
}