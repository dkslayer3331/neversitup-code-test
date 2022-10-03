package com.dazai.neversitupcodetest.data.local.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.dazai.neversitupcodetest.data.local.entities.HistoryEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface HistoryDao {

    @Query("select * from histories")
    fun getAllHistories(): Flow<List<HistoryEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addHistory(historyEntity: HistoryEntity)

    @Query("SELECT * FROM histories ORDER BY id DESC LIMIT 1")
    suspend fun getLastRecord(): HistoryEntity

    @Query("delete from histories")
    suspend fun clearAll()

}