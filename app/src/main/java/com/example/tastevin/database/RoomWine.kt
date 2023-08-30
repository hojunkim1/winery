package com.example.tastevin.database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.tastevin.domain.Wine

@Entity
data class RoomWine(
    @PrimaryKey @ColumnInfo(name = "wine_id") val id: Int,
    @ColumnInfo(name = "name_kr") val nameKr: String?,
    @ColumnInfo(name = "name_en") val nameEn: String?,
    @ColumnInfo(name = "producer") val producer: String,
    @ColumnInfo(name = "nation") val nation: String,
    @ColumnInfo(name = "type") val type: String,
    @ColumnInfo(name = "sweet") val sweet: Int,
    @ColumnInfo(name = "acidity") val acidity: Int,
    @ColumnInfo(name = "body") val body: Int,
    @ColumnInfo(name = "tannin") val tannin: Int,
    @ColumnInfo(name = "price") val price: String?,
    @ColumnInfo(name = "food") val food: String,
    @ColumnInfo(name = "pic_url") val url: String,
    @ColumnInfo(name = "count") val count: Int,
    @ColumnInfo(name = "recommend1") val recommend1: Int,
    @ColumnInfo(name = "recommend2") val recommend2: Int,
    @ColumnInfo(name = "recommend3") val recommend3: Int
)

fun RoomWine.asDomainModel(): Wine {
    return Wine(
        id = id,
        nameKr = nameKr,
        nameEn = nameEn,
        producer = producer,
        nation = nation,
        type = type,
        sweet = sweet,
        acidity = acidity,
        body = body,
        tannin = tannin,
        price = price,
        food = food,
        url = url,
        count = count,
        recommend1 = recommend1,
        recommend2 = recommend2,
        recommend3 = recommend3
    )
}