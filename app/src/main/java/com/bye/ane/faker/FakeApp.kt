package com.bye.ane.faker

import android.app.Application
import com.bye.ane.faker.startup.StartupOperation
import com.didi.drouter.api.DRouter
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class FakeApp : Application() {

    override fun onCreate() {
        super.onCreate()
        DRouter.init(this)
        StartupOperation.startupTask(this, BuildConfig.BUILD_TYPE)
    }
}