package com.example.tastevin.ui.bookmark

import androidx.lifecycle.ViewModel
import com.example.tastevin.TastevinApplication
import com.example.tastevin.database.AppDatabase
import com.example.tastevin.repository.Repository

class BookmarkViewModel : ViewModel() {
    private val db: Repository = Repository(AppDatabase.getDatabase(TastevinApplication()))
    val list = db.bookmarkList
}