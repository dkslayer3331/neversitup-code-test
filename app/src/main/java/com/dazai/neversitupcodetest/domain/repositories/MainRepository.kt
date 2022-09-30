package com.dazai.neversitupcodetest.domain.repositories

import com.dazai.neversitupcodetest.domain.models.History
import com.dazai.neversitupcodetest.domain.utils.Resource
import kotlinx.coroutines.flow.Flow

interface MainRepository {
    suspend fun getHistories() : Flow<List<History>>
    suspend fun addHistory(history: History)
}