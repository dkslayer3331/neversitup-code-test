package com.dazai.neversitupcodetest.data.repositories

import com.dazai.neversitupcodetest.data.local.source.LocalDataSource
import com.dazai.neversitupcodetest.data.remote.source.RemoteSource
import com.dazai.neversitupcodetest.domain.repositories.MainRepository
import com.dazai.neversitupcodetest.domain.models.History
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class MainRepositoryImpl @Inject constructor(
    private val localDataSource: LocalDataSource,
    private val remoteSource: RemoteSource
) : MainRepository {
    override suspend fun getHistories(): Flow<List<History>> {
        val remote = remoteSource.getCurrentPrice()
        remote.collect{
            localDataSource.addHistory(it.toDbEntity())
        }
        return localDataSource.getHistories().map { it.map { it.toDomain() } }
    }

    override suspend fun addHistory(history: History) {

    }

}