package com.dazai.neversitupcodetest.data.local.source

import com.dazai.neversitupcodetest.data.local.entities.CurrencyEntity
import com.dazai.neversitupcodetest.data.local.entities.HistoryEntity
import kotlinx.coroutines.flow.Flow


interface LocalDataSource {
    fun getHistories(): Flow<List<HistoryEntity>>
    suspend fun addHistory(historyEntity: HistoryEntity)
    suspend fun getLastRecord(): HistoryEntity
}