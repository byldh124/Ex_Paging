package com.moondroid.ex_paging.di

import com.moondroid.ex_paging.data.RepositoryImpl
import com.moondroid.ex_paging.domain.Repository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent


@Module
@InstallIn(SingletonComponent::class)
interface RepositoryModule {

    @Binds
    fun provideAppRepository(repository: RepositoryImpl): Repository
}