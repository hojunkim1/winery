package com.example.tastevin

import android.app.Application
import com.example.tastevin.database.AppDatabase

class TastevinApplication : Application() {
    val database: AppDatabase by lazy { AppDatabase.getDatabase(this) }
}