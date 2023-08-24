package com.example.tastevin

import android.app.Application
import timber.log.Timber

class TastevinApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        Timber.plant(Timber.DebugTree())
    }
}