package com.example.tastevin.database

import android.content.Context
import androidx.room.Dao
import androidx.room.Database
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.tastevin.database.entity.RoomBookmark
import com.example.tastevin.database.entity.RoomWine

@Dao
interface BookmarkDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertBookmark(bookmark: RoomBookmark)

    @Query("SELECT * FROM roombookmark")
    fun getAllBookmarks(): List<RoomBookmark>

    @Delete
    fun deleteBookmark(bookmark: RoomBookmark)
}

@Dao
interface WineDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertWine(wine: RoomWine)

    @Query("SELECT * FROM roomwine")
    fun getAllWines(): List<RoomWine>

    @Query("SELECT * FROM roomwine WHERE wine_id = :id")
    fun getWineById(id: Int): RoomWine

    @Delete
    fun deleteWine(wine: RoomWine)
}

@Database(entities = [RoomWine::class, RoomBookmark::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun wineDao(): WineDao
    abstract fun bookmarkDao(): BookmarkDao

    companion object {
        @Volatile
        private var INSTANCE: AppDatabase? = null

        fun getDatabase(context: Context): AppDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    AppDatabase::class.java,
                    "app_database"
                )
                    .allowMainThreadQueries()
                    .fallbackToDestructiveMigration()
                    .build()
                INSTANCE = instance
                return instance
            }
        }
    }
}