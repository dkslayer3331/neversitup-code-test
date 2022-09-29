package com.dazai.neversitupcodetest.data.remote.dto


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Time(
    @Json(name = "updated")
    val updated: String,
    @Json(name = "updatedISO")
    val updatedISO: String,
    @Json(name = "updateduk")
    val updateduk: String
)