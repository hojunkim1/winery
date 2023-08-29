package com.example.tastevin

import android.app.Application
import com.example.tastevin.database.AppDatabase
import timber.log.Timber

class TastevinApplication : Application() {

    val database: AppDatabase by lazy { AppDatabase.getDatabase(this) }

    override fun onCreate() {
        super.onCreate()
        Timber.plant(Timber.DebugTree())
    }
}