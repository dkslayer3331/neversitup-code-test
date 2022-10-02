package com.dazai.neversitupcodetest.data.remote.dto


import com.dazai.neversitupcodetest.data.local.entities.CurrencyEntity
import com.dazai.neversitupcodetest.data.local.entities.HistoryEntity
import com.dazai.neversitupcodetest.domain.utils.toDbEntity
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class CurrentPriceDto(
    @Json(name = "bpi")
    val bpi: Bpi,
    @Json(name = "chartName")
    val chartName: String,
    @Json(name = "disclaimer")
    val disclaimer: String,
    @Json(name = "time")
    val time: Time
){
    fun toDbEntity() : HistoryEntity{
        return HistoryEntity(
            id = System.currentTimeMillis(),
            updatedISO = time.updated, usd = bpi.uSD.toDbEntity(),
            gbp = bpi.gBP.toDbEntity(),
            eur = bpi.eUR.toDbEntity()
        )
    }

}