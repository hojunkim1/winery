package com.example.tastevin.database.wine

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class WineDB(
    @PrimaryKey @ColumnInfo(name = "wine_id") val id: Int,
    @ColumnInfo(name = "name_kr") val nameKr: String?,
    @ColumnInfo(name = "name_en") val nameEn: String?,
    @ColumnInfo val producer: String,
    @ColumnInfo val nation: String,
    @ColumnInfo val type: String,
    @ColumnInfo val sweet: Int,
    @ColumnInfo val acidity: Int,
    @ColumnInfo val body: Int,
    @ColumnInfo val tannin: Int,
    @ColumnInfo val price: String?,
    @ColumnInfo val food: String,
    @ColumnInfo(name = "pic_url") val url: String,
    @ColumnInfo val count: Int,
)