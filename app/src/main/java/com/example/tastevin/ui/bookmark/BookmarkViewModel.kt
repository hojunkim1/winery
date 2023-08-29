package com.example.tastevin.ui.bookmark

import androidx.lifecycle.ViewModel
import com.example.tastevin.database.WineDao
import com.example.tastevin.database.entity.asDomainModel
import com.example.tastevin.domain.Wine
import timber.log.Timber

class BookmarkViewModel : ViewModel() {

    fun getWineList(db: WineDao): List<Wine> {
        val list = db.getAllWines().map {
            it.asDomainModel()
        }
        Timber.tag("DB").d(list.toString())
        return list
    }
}