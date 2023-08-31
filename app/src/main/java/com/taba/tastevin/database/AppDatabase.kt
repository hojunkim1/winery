package com.taba.tastevin.database

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
    fun insertWine(wine: com.taba.tastevin.database.RoomWine)

    @Query("SELECT * FROM roomwine")
    fun getAllWines(): List<com.taba.tastevin.database.RoomWine>

    @Delete
    fun deleteWine(wine: com.taba.tastevin.database.RoomWine)
}

@Database(entities = [com.taba.tastevin.database.RoomWine::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun wineDao(): com.taba.tastevin.database.WineDao

    companion object {
        @Volatile
        private var INSTANCE: com.taba.tastevin.database.AppDatabase? = null

        fun getDatabase(context: Context): com.taba.tastevin.database.AppDatabase {
            return com.taba.tastevin.database.AppDatabase.Companion.INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    com.taba.tastevin.database.AppDatabase::class.java,
                    "app_database"
                )
                    .allowMainThreadQueries()
                    .fallbackToDestructiveMigration()
                    .build()
                com.taba.tastevin.database.AppDatabase.Companion.INSTANCE = instance
                return instance
            }
        }
    }
}