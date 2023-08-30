package com.taba.tastevin.ui.bookmark

import androidx.lifecycle.ViewModel
import com.taba.tastevin.database.asDomainModel
import com.taba.tastevin.domain.Wine

class BookmarkViewModel : ViewModel() {
    fun getWineList(db: com.taba.tastevin.database.WineDao): List<Wine> {
        val list = db.getAllWines().map {
            it.asDomainModel()
        }
        return list
    }
}