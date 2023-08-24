package com.example.tastevin.domain

import com.example.tastevin.database.entity.RoomWine

data class Wine(
    val id: Int,
    val nameKr: String?,
    val nameEn: String?,
    val producer: String,
    val nation: String,
    val type: String,
    val sweet: Int,
    val acidity: Int,
    val body: Int,
    val tannin: Int,
    val price: String?,
    val food: String,
    val url: String,
    val count: Int
)

fun Wine.asDatabaseModel(): RoomWine {
    return RoomWine(
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
        count = count
    )
}