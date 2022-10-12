package com.dazai.neversitupcodetest.data.repositories

import com.dazai.neversitupcodetest.data.local.entities.HistoryEntity
import com.dazai.neversitupcodetest.data.local.source.LocalDataSource
import com.dazai.neversitupcodetest.data.remote.source.RemoteSource
import com.dazai.neversitupcodetest.domain.models.History
import com.dazai.neversitupcodetest.domain.repositories.MainRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.toList
import javax.inject.Inject

class MainRepositoryImpl @Inject constructor(
    private val localDataSource: LocalDataSource,
    private val remoteSource: RemoteSource
) : MainRepository {

    override suspend fun getHistories(): Flow<List<History>> {
        return try {
            val remoteData = remoteSource.getCurrentPrice()
            localDataSource.addHistory(remoteData.toDbEntity())
            localDataSource.getHistories().map { it.map { it.toDomain() } }
        } catch (e: Exception) {
            if (localDataSource.getHistories().toList().isEmpty()) throw e
            localDataSource.getHistories().map { it.map { it.toDomain() } }
        }
    }

    override suspend fun addHistory(history: HistoryEntity) {
        localDataSource.addHistory(history)
    }

    override suspend fun getLastRecord(): History {
        return localDataSource.getLastRecord().toDomain()
    }

}