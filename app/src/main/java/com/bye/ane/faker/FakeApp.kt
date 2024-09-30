package com.bye.ane.faker

import android.app.Application
import com.bye.ane.faker.startup.StartupOperation

class FakeApp:Application() {

    override fun onCreate() {
        super.onCreate()
        StartupOperation.startupTask(this, BuildConfig.BUILD_TYPE)

    }
}