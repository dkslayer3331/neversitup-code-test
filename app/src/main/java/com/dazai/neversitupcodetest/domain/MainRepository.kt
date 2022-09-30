package com.dazai.neversitupcodetest.domain

import com.dazai.neversitupcodetest.domain.models.History
import com.dazai.neversitupcodetest.domain.utils.Resource
import kotlinx.coroutines.flow.Flow

interface MainRepository {
    suspend fun getHistories() : Resource<Flow<List<History>>>
    suspend fun getHistory(history: History)
}