package com.bye.ane.faker.startup.task

import android.app.Application
import com.bye.ane.shared.store.LocalStore
import com.caij.app.startup.Task

class LocalStoreTask(private val app: Application) : Task() {

    companion object {
        const val TASK_NAME = "task_name_local_store"
    }



    override fun run() {
        LocalStore.initialize(app)
    }

    override fun dependencies(): List<String> {
        return emptyList()
    }

    override fun getTaskName(): String {
        return TASK_NAME
    }

}