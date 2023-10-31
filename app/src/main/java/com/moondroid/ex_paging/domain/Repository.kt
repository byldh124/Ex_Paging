package com.moondroid.ex_paging.domain

import com.moondroid.ex_paging.data.Data
import kotlinx.coroutines.flow.Flow

interface Repository {
    fun getData(
        pageNo: String,
    ): Flow<List<Data>>
}