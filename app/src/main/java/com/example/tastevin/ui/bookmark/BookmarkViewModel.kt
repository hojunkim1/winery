package com.example.tastevin.ui.bookmark

import androidx.lifecycle.ViewModel
import com.example.tastevin.database.WineDao
import com.example.tastevin.database.asDomainModel
import com.example.tastevin.domain.Wine

class BookmarkViewModel : ViewModel() {
    fun getWineList(db: WineDao): List<Wine> {
        val list = db.getAllWines().map {
            it.asDomainModel()
        }
        return list
    }
}