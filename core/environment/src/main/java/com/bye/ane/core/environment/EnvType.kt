package com.bye.ane.core.environment

enum class EnvType(name: String) {
    DEBUG("debug"),
    STAGING("staging"),
    RELEASE("release")
}


fun getEnvTypeByKey(name: String): EnvType {
    return when (name) {
        EnvType.DEBUG.name -> {
            EnvType.DEBUG
        }

        EnvType.STAGING.name -> {
            EnvType.STAGING
        }

        EnvType.RELEASE.name -> {
            EnvType.RELEASE
        }

        else -> {
            EnvType.RELEASE
        }
    }
}

fun getEnvTypeByBuildTypeKey(name:String): EnvType {
    return when (name) {
        BuildType.DEBUG.name -> {
            EnvType.DEBUG
        }

        BuildType.STAGING.name -> {
            EnvType.STAGING
        }

        BuildType.RELEASE.name -> {
            EnvType.RELEASE
        }

        else -> {
            EnvType.RELEASE
        }
    }
}