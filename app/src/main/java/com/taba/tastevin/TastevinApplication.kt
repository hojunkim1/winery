package com.taba.tastevin

import android.app.Application

class TastevinApplication : Application() {
    val database: com.taba.tastevin.database.AppDatabase by lazy {
        com.taba.tastevin.database.AppDatabase.getDatabase(
            this
        )
    }
}