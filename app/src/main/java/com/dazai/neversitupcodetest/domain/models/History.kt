package com.dazai.neversitupcodetest.domain.models

import com.dazai.neversitupcodetest.data.local.entities.CurrencyEntity

data class History(
    val id : Long,
    val updatedISO : String,
    val usd : Currency,
    val gbp : Currency,
    val eur : Currency
)
