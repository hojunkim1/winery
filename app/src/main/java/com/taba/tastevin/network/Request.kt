package com.taba.tastevin.network

import com.squareup.moshi.Json

data class GptRequest(
    @Json(name = "ocr_text") val ocrText: String
)