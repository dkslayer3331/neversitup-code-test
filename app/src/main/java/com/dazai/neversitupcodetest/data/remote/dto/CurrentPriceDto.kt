package com.dazai.neversitupcodetest.data.remote.dto


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class CurrentPriceDto(
    @Json(name = "bpi")
    val bpi: Bpi,
    @Json(name = "chartName")
    val chartName: String,
    @Json(name = "disclaimer")
    val disclaimer: String,
    @Json(name = "time")
    val time: Time
)