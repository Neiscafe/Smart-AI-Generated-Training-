package com.example.smart_development

import android.app.Application
import com.example.smart_development.di.appModules
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class App: Application() {
    override fun onCreate() {
        super.onCreate()
        configureDI()
    }

    private fun configureDI() = startKoin {
        applicationContext
        androidContext(this@App)
        modules(appModules)
    }
}