package com.dazai.neversitupcodetest.data

import android.content.Context
import androidx.hilt.work.HiltWorker
import androidx.work.CoroutineWorker
import androidx.work.WorkerParameters
import com.dazai.neversitupcodetest.domain.usecases.GetHistories
import dagger.assisted.Assisted
import dagger.assisted.AssistedInject
import kotlinx.coroutines.delay

@HiltWorker
class GetLatestPricesWorker @AssistedInject constructor(
    @Assisted appContext: Context,
    @Assisted workerParams: WorkerParameters,
    private val getHistories: GetHistories
) : CoroutineWorker(appContext, workerParams) {
    override suspend fun doWork(): Result {
        return try {
            delay(1000)
            getHistories.invoke()
            Result.success()
        }catch (e : Exception){
            Result.failure()
        }
    }

}