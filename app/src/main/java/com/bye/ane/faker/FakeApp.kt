package com.bye.ane.faker

import android.app.Application
import com.bye.ane.faker.startup.StartupOperation
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class FakeApp : Application() {

    override fun onCreate() {
        super.onCreate()
        StartupOperation.startupTask(this, BuildConfig.BUILD_TYPE)
    }
}