package com.dazai.neversitupcodetest.domain.utils

import com.dazai.neversitupcodetest.data.local.entities.CurrencyEntity
import com.dazai.neversitupcodetest.data.remote.dto.EUR
import com.dazai.neversitupcodetest.data.remote.dto.GBP
import com.dazai.neversitupcodetest.data.remote.dto.USD
import com.dazai.neversitupcodetest.domain.models.Currency

fun CurrencyEntity.toUiModel() : Currency{
    return Currency(code = code, rate = "$symbol$rate", rateFloat = rateFloat, symbol = symbol)
}

fun EUR.toDbEntity() : CurrencyEntity{
    return CurrencyEntity(code = code, rate = rate, rateFloat = rateFloat, symbol = symbol)
}

fun GBP.toDbEntity() : CurrencyEntity{
    return CurrencyEntity(code = code, rate = rate, rateFloat = rateFloat, symbol = symbol)
}

fun USD.toDbEntity() : CurrencyEntity{
    return CurrencyEntity(code = code, rate = rate, rateFloat = rateFloat, symbol = symbol)
}