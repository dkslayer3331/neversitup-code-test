package com.dazai.neversitupcodetest.domain.models

data class Currency(
    val code: String,
    val rate: String,
    val rateFloat: Double,
    val symbol: String
)
