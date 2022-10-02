package com.dazai.neversitupcodetest.data.remote.source

import com.dazai.neversitupcodetest.data.remote.dto.CurrentPriceDto
import kotlinx.coroutines.flow.Flow

interface RemoteSource {
    suspend fun getCurrentPrice() : CurrentPriceDto
}