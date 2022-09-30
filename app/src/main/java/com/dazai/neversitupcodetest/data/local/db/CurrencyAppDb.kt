package com.dazai.neversitupcodetest.data.local.db

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.dazai.neversitupcodetest.data.local.entities.CurrencyEntity
import com.dazai.neversitupcodetest.data.local.entities.HistoryEntity
import com.dazai.neversitupcodetest.data.local.typeConverters.CurrencyEntityTypeConverter


@Database(exportSchema = false, version = 1, entities = [CurrencyEntity::class, HistoryEntity::class])
@TypeConverters(CurrencyEntityTypeConverter::class)
abstract class CurrencyAppDb : RoomDatabase() {
    abstract fun historyDao() : HistoryDao
}