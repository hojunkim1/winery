package com.example.tastevin.network

import com.example.tastevin.domain.Wine
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET

private const val BASE_URL = ""

private val moshi = Moshi.Builder()
    .add(KotlinJsonAdapterFactory())
    .build()

private val retrofit = Retrofit.Builder()
    .addConverterFactory(MoshiConverterFactory.create(moshi))
    .baseUrl(BASE_URL)
    .build()

interface WineApiService {

    @GET("/wines")
    suspend fun getWines(): List<Wine>
}

object WineApi {
    val retrofitService: WineApiService by lazy {
        retrofit.create(WineApiService::class.java)
    }
}