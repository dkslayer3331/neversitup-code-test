package com.dazai.neversitupcodetest.presentation.screens

import com.dazai.neversitupcodetest.domain.models.Currency

data class CurrencyConverterScreen(
    val currencies: List<String> = emptyList(),
    val currencyObj: List<Currency> = emptyList(),
    val convertedAmount: Double = 0.0,
    val error: String? = null
)
