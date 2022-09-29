package com.dazai.neversitupcodetest.data.remote.dto


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class USD(
    @Json(name = "code")
    val code: String,
    @Json(name = "description")
    val description: String,
    @Json(name = "rate")
    val rate: String,
    @Json(name = "rate_float")
    val rateFloat: Double,
    @Json(name = "symbol")
    val symbol: String
)