package com.dazai.neversitupcodetest.domain.usecases

import com.dazai.neversitupcodetest.domain.repositories.MainRepository
import com.dazai.neversitupcodetest.presentation.SealedCurrency
import javax.inject.Inject

class CalculatorUseCase @Inject constructor(
    private val repository: MainRepository
) {
    suspend fun execute(input: Float, currency: SealedCurrency?): Double {
        val latestRecord = repository.getLastRecord()
        return when (currency) {
            is SealedCurrency.EUR -> input / latestRecord.eur.rateFloat
            is SealedCurrency.GBP -> input / latestRecord.gbp.rateFloat
            is SealedCurrency.USD -> input / latestRecord.usd.rateFloat
            else -> throw Exception("Please select a currency type to convert")
        }
    }
}