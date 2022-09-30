package com.dazai.neversitupcodetest.data.local.entities

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.dazai.neversitupcodetest.data.remote.TableNames

@Entity(tableName = TableNames.history)
data class HistoryEntity(
    @PrimaryKey
    val id : Int,
    val updatedISO : String,
    val usd : CurrencyEntity,
    val gbp : CurrencyEntity,
    val eur : CurrencyEntity
)