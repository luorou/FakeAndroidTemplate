package com.bye.ane.faker.startup.task

import android.app.Application
import com.bye.ane.core.environment.EnvProvider
import com.bye.ane.core.environment.EnvStoreKeys
import com.bye.ane.core.environment.getBuildTypeByKey
import com.bye.ane.core.environment.getEnvTypeByBuildTypeKey
import com.bye.ane.shared.store.LocalStore
import com.bye.ane.shared.store.StoreTypes
import com.caij.app.startup.Task

class SetEnvTask(private val app: Application, private val buildTypeKey: String) : Task() {

    companion object {
        const val TASK_NAME = "task_name_set_env"
    }

    override fun run() {
        //
        val localEnvType =
            LocalStore.get(app, StoreTypes.MMKV).getString(EnvStoreKeys.STORE_KEY_ENV_TYPE)
        if (!localEnvType.isNullOrEmpty()) {
            val envType = getEnvTypeByBuildTypeKey(localEnvType)
            val buildType = getBuildTypeByKey(buildTypeKey)
            EnvProvider.initBuildType(buildType)
            EnvProvider.initEnvType(app, envType)
            return
        }
        //
        val buildType = getBuildTypeByKey(buildTypeKey)
        val envType = getEnvTypeByBuildTypeKey(buildTypeKey)
        EnvProvider.initBuildType(buildType)
        EnvProvider.initEnvType(app, envType)
    }


    override fun dependencies(): List<String> {
        return listOf(LocalStoreTask.TASK_NAME)
    }

    override fun getTaskName(): String {
        return TASK_NAME
    }

}