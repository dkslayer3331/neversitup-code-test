package com.dazai.neversitupcodetest.data.di

import com.dazai.neversitupcodetest.data.repositories.MainRepositoryImpl
import com.dazai.neversitupcodetest.domain.repositories.MainRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {
    @Binds
    abstract fun bindMainRepo(impl : MainRepositoryImpl) : MainRepository
}