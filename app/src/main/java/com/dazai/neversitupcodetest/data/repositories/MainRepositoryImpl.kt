package com.dazai.neversitupcodetest.data.repositories

import com.dazai.neversitupcodetest.data.local.source.LocalDataSource
import com.dazai.neversitupcodetest.data.remote.source.RemoteSource
import com.dazai.neversitupcodetest.domain.MainRepository
import com.dazai.neversitupcodetest.domain.models.History
import com.dazai.neversitupcodetest.domain.utils.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class MainRepositoryImpl @Inject constructor(
    private val localDataSource: LocalDataSource,
    private val remoteSource: RemoteSource
) : MainRepository {
    override suspend fun getHistories(): Resource<Flow<List<History>>> {
        return try {
            remoteSource.getCurrentPrice().map {

            }
            return Resource.Success(localDataSource.getHistories().map { it. })
        }catch (e : Exception){
            Resource.Error(e.message ?: "something went wrong")
        }
    }

    override suspend fun getHistory(history: History) {

    }
}