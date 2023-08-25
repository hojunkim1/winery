package com.example.tastevin.network

import com.example.tastevin.database.entity.RoomWine
import com.example.tastevin.domain.Wine
import com.squareup.moshi.Json

data class NetworkWineRecommend(
    @Json(name = "detail") val wine: NetworkWine,
    @Json(name = "recommendations") val recommendations: List<NetworkWine>
)

data class NetworkWine(
    @Json(name = "wine_id") val id: Int,
    @Json(name = "name_kr") val nameKr: String?,
    @Json(name = "name_en") val nameEn: String?,
    @Json val producer: String,
    @Json val nation: String,
    @Json val type: String,
    @Json val sweet: Int,
    @Json val acidity: Int,
    @Json val body: Int,
    @Json val tannin: Int,
    @Json val price: String?,
    @Json val food: String,
    @Json(name = "pic_url") val url: String,
    @Json val count: Int,
    @Json val recommend1: Int?,
    @Json val recommend2: Int?,
    @Json val recommend3: Int?
)

fun NetworkWine.asDomainModel(): Wine {
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

fun NetworkWine.asDatabaseModel(): RoomWine {
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
        count = count,
        recommend1 = recommend1,
        recommend2 = recommend2,
        recommend3 = recommend3
    )
}

fun NetworkWineRecommend.asDomainModel(): List<Wine> {
    val recommendationList = recommendations.map { it.asDomainModel() }
    return recommendationList
}