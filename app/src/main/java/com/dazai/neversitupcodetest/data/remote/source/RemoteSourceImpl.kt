package com.dazai.neversitupcodetest.data.remote.source

import com.dazai.neversitupcodetest.data.remote.CurrencyApi
import com.dazai.neversitupcodetest.data.remote.dto.CurrentPriceDto
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class RemoteSourceImpl @Inject constructor(
    private val api: CurrencyApi
) : RemoteSource {
    override suspend fun getCurrentPrice(): Flow<CurrentPriceDto> {
        return flow{ emit(api.getCurrentPrice()) }
    }
}