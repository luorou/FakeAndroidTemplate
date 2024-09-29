package com.hekr.core.startup

import android.app.Application
import com.caij.app.startup.Config
import com.caij.app.startup.DGAppStartup
import com.caij.app.startup.OnProjectListener
import com.bye.ane.faker.startup.task.BuglyTask
import com.hekr.core.startup.task.LocalStoreTask
import com.hekr.core.startup.task.PrDownloaderTask
import com.hekr.core.startup.task.RouterTask
import com.bye.ane.faker.startup.task.SetEnvTask


object StartupOperation {

    fun startupTask(app: Application, buildType: String) {
        val config: Config = Config()
        config.isStrictMode = true
        DGAppStartup.Builder()
            .add(BuglyTask(app))
            .add(LocalStoreTask(app))
            .add(RouterTask(app))
            .add(SetEnvTask(app,buildType))
            .add(PrDownloaderTask(app))
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