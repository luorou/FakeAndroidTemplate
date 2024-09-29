package com.bye.ane.faker.startup.task

import android.app.Application
import android.util.Log
import com.caij.app.startup.Task

class SetEnvTask(private val app: Application, val buildType: String) : Task() {

    companion object {
        const val TASK_NAME = "task_name_set_env"
    }

    override fun run() {
        //
        val localType = LocalStore.get(StoreTypes.MMKV).getString(LocalStoreKeys.STORE_KEY_ENV_TYPE)
        Log.e("TAG---", localType + "")
        //
        if (localType.isNullOrEmpty()) {
            val type = getBuildTypeByKey(buildType)
            EnvProvider.initBuildTypeByKey(type.key)
            return
        }
        //
        val env = getBuildTypeByEnvKey(localType)
        //
        EnvProvider.initBuildTypeByKey(env.key)
        //
    }


    override fun dependencies(): List<String> {
        return listOf(LocalStoreTask.TASK_NAME)
    }

    override fun getTaskName(): String {
        return TASK_NAME
    }

}