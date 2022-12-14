package com.dazai.neversitupcodetest.data.di

import com.dazai.neversitupcodetest.data.local.source.LocalDataSource
import com.dazai.neversitupcodetest.data.local.source.LocalDataSourceImpl
import com.dazai.neversitupcodetest.data.remote.source.RemoteSource
import com.dazai.neversitupcodetest.data.remote.source.RemoteSourceImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class DataProvidersModule {

    @Binds
    abstract fun bindRemoteSource(impl: RemoteSourceImpl): RemoteSource

    @Binds
    abstract fun bindLocalSource(impl: LocalDataSourceImpl): LocalDataSource

}