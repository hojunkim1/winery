package com.example.tastevin.repository

import com.example.tastevin.database.AppDatabase
import com.example.tastevin.database.entity.RoomBookmark
import com.example.tastevin.database.entity.asDomainModel
import com.example.tastevin.domain.Wine
import com.example.tastevin.domain.asDatabaseModel
import com.example.tastevin.network.WineApi
import com.example.tastevin.network.asDatabaseModel
import timber.log.Timber

class Repository(private val database: AppDatabase) {

    companion object {
        const val TAG = "REPOSITORY"
    }

    /**
     * 북마크의 id 리스트들만 가져온다
     */
    val bookmarkIndexList = database.bookmarkDao().getAllBookmarks().map {
        it.asDomainModel()
    }

    /**
     * 북마크된 모든 와인을 가져온다
     */
    val bookmarkList = database.wineDao().getAllWines().map {
        it.asDomainModel()
    }

    /**
     * 북마크의 id로 와인을 가져온다
     */
    fun getBookmarkByWineId(id: Int): Wine {
        return database.wineDao().getWineById(id).asDomainModel()
    }

    /**
     * 입력된 와인을 새로운 북마크로 추가한다.
     */
    fun addBookmark(wine: Wine): Boolean {
        return try {
            database.bookmarkDao().insertBookmark(RoomBookmark(wineId = wine.id))
            database.wineDao().insertWine(wine.asDatabaseModel())
            true
        } catch (e: Exception) {
            Timber.tag(TAG).e(e.toString())
            false
        }
    }

    /**
     * 입력된 와인을 북마크에서 삭제한다.
     */
    fun deleteBookmark(wine: Wine): Boolean {
        return try {
            database.bookmarkDao().deleteBookmark(RoomBookmark(wineId = wine.id))
            database.wineDao().deleteWine(wine.asDatabaseModel())
            true
        } catch (e: Exception) {
            Timber.tag(TAG).e(e.toString())
            false
        }
    }

    /**
     * 와인의 id로 즉시 서버에서 북마크로 와인을 저장한다
     */
    private suspend fun fetchWine(id: Int) {
        try {
            val newWine = WineApi.retrofitService.getWineById(id).asDatabaseModel()
            database.wineDao().insertWine(newWine)
        } catch (e: Exception) {
            Timber.tag(TAG).e(e.toString())
        }
    }

    /**
     * 와인 데이터베이스와 북마크 데이터베이스를 동기화한다.
     * 데이터베이스 관리 시 오류가 있을 시 한 번 실행해보자.
     */
    suspend fun refresh() {
        val bookmarkList = database.bookmarkDao().getAllBookmarks().map { it.wineId }
        val wineList = database.wineDao()
        for (bookmarkId in bookmarkList) {
            try {
                wineList.getWineById(bookmarkId)
            } catch (e: Exception) {
                fetchWine(bookmarkId)
                Timber.tag(TAG).e(e.toString())
            }
        }
        for (wine in wineList.getAllWines()) {
            if (!bookmarkList.contains(wine.id)) {
                wineList.deleteWine(wine)
            }
        }
    }
}