package com.moondroid.ex_paging.domain

import androidx.paging.PagingData
import com.moondroid.ex_paging.data.Data
import kotlinx.coroutines.flow.Flow

interface Repository {
    fun getData(): Flow<PagingData<Data>>
}