package com.dazai.neversitupcodetest.presentation

sealed class SealedCurrency {
    object USD : SealedCurrency()
    object GBP : SealedCurrency()
    object EUR : SealedCurrency()
    companion object {
        fun toSealedClass(input: String): SealedCurrency {
            return when (input) {
                "USD" -> USD
                "GBP" -> GBP
                else -> EUR
            }
        }
    }
}
