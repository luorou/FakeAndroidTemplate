package com.bye.ane.faker.startup

import android.app.Application
import com.bye.ane.faker.startup.MonitorTaskListener
import com.bye.ane.faker.startup.ThreadManager
import com.caij.app.startup.Config
import com.caij.app.startup.DGAppStartup
import com.caij.app.startup.OnProjectListener
import com.bye.ane.faker.startup.task.LocalStoreTask
import com.bye.ane.faker.startup.task.SetEnvTask


object StartupOperation {

    fun startupTask(app: Application, buildType: String) {
        val config: Config = Config()
        config.isStrictMode = true
        DGAppStartup.Builder()
            .add(LocalStoreTask(app))
            .add(SetEnvTask(app,buildType))
            .setConfig(config)
            .addTaskListener(MonitorTaskListener("Tag--startup", true))
            .setExecutorService(ThreadManager.getInstance().WORK_EXECUTOR)
            .addOnProjectExecuteListener(object : OnProjectListener {
                override fun onProjectStart() {
                }

                override fun onProjectFinish() {
                }

                override fun onStageFinish() {
                }
            })
            .create()
            .start()
    }
}