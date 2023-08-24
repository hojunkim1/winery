package com.example.tastevin.network

import com.squareup.moshi.Json

data class WineJSON(
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
)