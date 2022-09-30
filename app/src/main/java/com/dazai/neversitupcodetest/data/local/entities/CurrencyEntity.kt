package com.dazai.neversitupcodetest.data.local.entities

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class CurrencyEntity(
    val code: String,
    val rate: String,
    val rateFloat: Double,
    val symbol: String
)
