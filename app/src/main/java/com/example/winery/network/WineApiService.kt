package com.example.winery.network

import com.example.winery.model.Wine
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

private const val BASE_URL = ""

private val moshi = Moshi.Builder()
    .add(KotlinJsonAdapterFactory())
    .build()

private val retrofit = Retrofit.Builder()
    .addConverterFactory(MoshiConverterFactory.create(moshi))
    .baseUrl(BASE_URL)
    .build()

interface WineApiService {

    @GET
    suspend fun getWines(): List<Wine>

}

object WineApi {
    val retrofitService: WineApiService by lazy {
        retrofit.create(WineApiService::class.java)
    }
}