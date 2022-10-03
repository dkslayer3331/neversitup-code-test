package com.dazai.neversitupcodetest.data.local.source

import com.dazai.neversitupcodetest.data.local.db.CurrencyAppDb
import com.dazai.neversitupcodetest.data.local.entities.HistoryEntity
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class LocalDataSourceImpl @Inject constructor(
    private val db: CurrencyAppDb
) : LocalDataSource {
    override fun getHistories(): Flow<List<HistoryEntity>> {
        return db.historyDao().getAllHistories()
    }

    override suspend fun addHistory(historyEntity: HistoryEntity) {
        db.historyDao().addHistory(historyEntity)
    }

    override suspend fun getLastRecord(): HistoryEntity {
        return db.historyDao().getLastRecord()
    }
}