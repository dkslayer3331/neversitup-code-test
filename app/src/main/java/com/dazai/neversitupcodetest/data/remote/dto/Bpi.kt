package com.dazai.neversitupcodetest.data.remote.dto


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Bpi(
    @Json(name = "EUR")
    val eUR: EUR,
    @Json(name = "GBP")
    val gBP: GBP,
    @Json(name = "USD")
    val uSD: USD
)