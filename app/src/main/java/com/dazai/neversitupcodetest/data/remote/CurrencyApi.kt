package com.dazai.neversitupcodetest.data.remote

import com.dazai.neversitupcodetest.data.remote.dto.CurrentPriceDto
import retrofit2.http.GET

interface CurrencyApi {
    @GET("/v1/bpi/currentprice.json")
    suspend fun getCurrentPrice(): CurrentPriceDto
}