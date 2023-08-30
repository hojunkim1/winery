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

@Dao
interface WineDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertWine(wine: RoomWine)

    @Query("SELECT * FROM roomwine")
    fun getAllWines(): List<RoomWine>

    @Delete
    fun deleteWine(wine: RoomWine)
}

@Database(entities = [RoomWine::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun wineDao(): WineDao

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