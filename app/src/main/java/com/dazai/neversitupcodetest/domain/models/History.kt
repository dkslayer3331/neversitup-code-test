package com.dazai.neversitupcodetest.domain.models

data class History(
    val id : Long,
    val updatedISO : String,
    val usd : Currency,
    val gbp : Currency,
    val eur : Currency
)
