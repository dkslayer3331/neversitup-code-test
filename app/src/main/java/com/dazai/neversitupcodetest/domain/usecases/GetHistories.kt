package com.dazai.neversitupcodetest.domain.usecases

import com.dazai.neversitupcodetest.domain.repositories.MainRepository
import com.dazai.neversitupcodetest.domain.models.History
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetHistories @Inject constructor(
    private val repository: MainRepository
) {
    suspend operator fun invoke() : Flow<List<History>>{
        return repository.getHistories()
    }
}