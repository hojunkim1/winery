package com.example.tastevin.domain

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
    val url: String
)