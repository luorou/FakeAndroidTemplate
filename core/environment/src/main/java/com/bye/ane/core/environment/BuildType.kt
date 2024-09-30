package com.bye.ane.core.environment

enum class BuildType(val type: String) {
    DEBUG("debug"),
    STAGING("staging"),
    RELEASE("release")
}


fun getBuildTypeByKey(key: String): BuildType {
    return when (key) {
        BuildType.DEBUG.type -> {
            BuildType.DEBUG
        }
        BuildType.STAGING.type -> {
            BuildType.STAGING
        }
        BuildType.RELEASE.type -> {
            BuildType.RELEASE
        }
        else -> {
            BuildType.RELEASE
        }
    }
}