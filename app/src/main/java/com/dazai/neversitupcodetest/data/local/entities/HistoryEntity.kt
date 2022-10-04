package com.dazai.neversitupcodetest.data.local.entities

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.dazai.neversitupcodetest.data.remote.TableNames
import com.dazai.neversitupcodetest.domain.models.Currency
import com.dazai.neversitupcodetest.domain.models.History
import com.dazai.neversitupcodetest.domain.utils.toUiModel

@Entity(tableName = TableNames.history)
data class HistoryEntity(
    val updatedISO: String,
    @PrimaryKey
    val id: Long,
    val usd: CurrencyEntity,
    val gbp: CurrencyEntity,
    val eur: CurrencyEntity
) {
    fun toDomain(): History {
        return History(
            id = id,
            updatedISO = updatedISO,
            usd = usd.toUiModel(),
            gbp = gbp.toUiModel(),
            eur = eur.toUiModel()
        )
    }
}