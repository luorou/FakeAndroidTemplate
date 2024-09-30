package com.bye.ane.faker.startup.task

import android.app.Application
import android.util.Log
import com.bye.ane.core.environment.EnvProvider
import com.bye.ane.core.environment.getBuildTypeByKey
import com.bye.ane.core.global.LocalStoreKeys
import com.bye.ane.shared.store.LocalStore
import com.bye.ane.shared.store.StoreTypes
import com.caij.app.startup.Task

class SetEnvTask(private val app: Application, private val buildType: String) : Task() {

    companion object {
        const val TASK_NAME = "task_name_set_env"
    }

    override fun run() {
        //
        val localType = LocalStore.get(app,StoreTypes.MMKV).getString(LocalStoreKeys.STORE_KEY_BUILD_TYPE)
        Log.e("TAG---", localType + "")
        //
        if (localType.isNullOrEmpty()) {
            val type = getBuildTypeByKey(buildType)
            EnvProvider.initBuildType(type)
            return
        }
        //
        val type = getBuildTypeByKey(localType)
        //
        EnvProvider.initBuildType(type)
        //
    }


    override fun dependencies(): List<String> {
        return listOf(LocalStoreTask.TASK_NAME)
    }

    override fun getTaskName(): String {
        return TASK_NAME
    }

}