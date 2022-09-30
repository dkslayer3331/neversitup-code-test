package com.dazai.neversitupcodetest.data.local.typeConverters

import androidx.room.TypeConverter
import com.dazai.neversitupcodetest.data.local.entities.CurrencyEntity
import com.squareup.moshi.Moshi
import javax.inject.Inject

class CurrencyEntityTypeConverter @Inject constructor(
    private val moshi: Moshi
) {
    @TypeConverter
    fun toObj(json : String) : CurrencyEntity{
        return moshi.adapter(CurrencyEntity::class.java).fromJson(json)!!
    }

    @TypeConverter
    fun toJson(currencyEntity: CurrencyEntity) : String{
        return moshi.adapter(CurrencyEntity::class.java).toJson(currencyEntity)
    }
}