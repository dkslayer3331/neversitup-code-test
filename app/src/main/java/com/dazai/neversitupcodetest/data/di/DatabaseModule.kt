package com.dazai.neversitupcodetest.data.di

import android.content.Context
import androidx.room.Room
import com.dazai.neversitupcodetest.data.local.db.CurrencyAppDb
import com.dazai.neversitupcodetest.data.local.typeConverters.CurrencyEntityTypeConverter
import com.squareup.moshi.Moshi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    @Provides
    fun provideDatabase(@ApplicationContext context: Context, moshi: Moshi) : CurrencyAppDb{
        return Room.databaseBuilder(context, CurrencyAppDb::class.java, "history-db")
            .fallbackToDestructiveMigration()
            .addTypeConverter(CurrencyEntityTypeConverter(moshi))
            .build()
    }

    @Provides
    fun provideTypeConverter(moshi: Moshi) : CurrencyEntityTypeConverter{
        return CurrencyEntityTypeConverter(moshi)
    }

}