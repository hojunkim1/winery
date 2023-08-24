package com.example.tastevin.network

import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path
import retrofit2.http.Query

private const val BASE_URL = "http://10.0.2.2:8000/"

private val moshi = Moshi.Builder()
    .add(KotlinJsonAdapterFactory())
    .build()

private val retrofit = Retrofit.Builder()
    .addConverterFactory(MoshiConverterFactory.create(moshi))
    .baseUrl(BASE_URL)
    .build()

interface Service {

    @GET("wines/{id}")
    suspend fun getWineById(@Path("id") id: Int): WineJSON

    @POST("wines/search/{text}")
    suspend fun searchWine(
        @Path("text") text: String,
        @Query("lang") lang: String
    )

    @GET("top")
    suspend fun getTopWines(): List<WineJSON>
}

object WineApi {
    val retrofitService: Service by lazy {
        retrofit.create(Service::class.java)
    }
}