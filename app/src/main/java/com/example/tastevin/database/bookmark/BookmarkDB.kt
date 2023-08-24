package com.example.tastevin.database.bookmark

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class BookmarkDB(
    @PrimaryKey val id: Int,
    @ColumnInfo(name = "wine_id") val wineId: Int
)