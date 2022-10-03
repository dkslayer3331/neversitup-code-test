package com.dazai.neversitupcodetest.data.local.entities

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
@Entity
data class CurrencyEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val code: String,
    val rate: String,
    val rateFloat: Double,
    val symbol: String
)
