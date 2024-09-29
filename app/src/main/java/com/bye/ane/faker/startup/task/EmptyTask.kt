package com.hekr.core.startup.task

import android.util.Log
import com.caij.app.startup.Task

class EmptyTask(id: String) : Task() {

    companion object {
        const val TASK_NAME = "task_empty"
    }

    override fun run() {
        Log.i("", "")
    }

    override fun dependencies(): List<String> {
        return emptyList()
    }

    override fun getTaskName(): String {
        return TASK_NAME
    }
}