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