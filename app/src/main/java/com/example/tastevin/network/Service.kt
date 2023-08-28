package com.example.tastevin.network

import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path
import retrofit2.http.Query

private const val BASE_URL = "http://192.168.0.13:8000/"
//"http://10.0.2.2:8000/"

private val moshi = Moshi.Builder()
    .add(KotlinJsonAdapterFactory())
    .build()

private val retrofit = Retrofit.Builder()
    .addConverterFactory(MoshiConverterFactory.create(moshi))
    .baseUrl(BASE_URL)
    .build()

interface Service {

    /**
     * id 를 전달하면 해당 와인과 추천 와인 데이터가 온다.
     * 사용 예 : .getRecommendationById(1)
     */
    @GET("/wines/{wine_id}")
    fun getRecommendationById(@Path("wine_id") id: Int): NetworkWineRecommendation

    /**
     * id 를 전달하면 해당 와인 데이터가 온다.
     * 사용 예 : .getWineById(1)
     */
    @GET("/wineeeee/{wine_id}")
    suspend fun getWineById(
        @Path("wine_id") id: Int
    ): NetworkWine

    /**
     * 단순 검색을 위한 api 로, 입력 받은 데이터를 전달하면 유사 와인 리스트가 온다.
     * 사용 예: .searchWine("wine_name", "en")
     */
    @POST("wines/search/{text}")
    suspend fun searchWine(
        @Path("text") text: String,
        @Query("lang") lang: String
    ): List<NetworkWine>

    /**
     * 상위 순위권의 와인들을 가져 오기 위한 api 이다.
     * 사용 예 : .getTopWines()
     */
    @GET("top")
    suspend fun getTopWines(): List<NetworkWine>

    /**
     * OCR 로 긁어온 데이터들을 ChatGPT 로 추정하여 검색하는 api로, 추정되는 와인 리스트가 온다.
     * 사용 예: .searchWinesByOcrText(GptRequest(ocrText = "ocr_text")))
     */
    @POST("gpt")
    suspend fun searchWinesByOcrText(
        @Body gptRequest: GptRequest
    ): List<NetworkWine>
}

object WineApi {
    val retrofitService: Service by lazy {
        retrofit.create(Service::class.java)
    }
}