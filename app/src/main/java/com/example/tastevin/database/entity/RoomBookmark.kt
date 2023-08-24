package com.example.tastevin.database.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.tastevin.domain.Bookmark

@Entity
data class RoomBookmark(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    @ColumnInfo(name = "wine_id") val wineId: Int
)

fun RoomBookmark.asDomainModel(): Bookmark {
    return Bookmark(
        id = id,
        wineId = wineId
    )
}