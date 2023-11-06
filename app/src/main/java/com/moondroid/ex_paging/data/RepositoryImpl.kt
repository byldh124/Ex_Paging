package com.moondroid.ex_paging.data

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.moondroid.ex_paging.common.Constant
import com.moondroid.ex_paging.domain.Repository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import retrofit2.Retrofit
import javax.inject.Inject

class RepositoryImpl @Inject constructor(private val retrofit: Retrofit) : Repository {
    override fun getData(): Flow<PagingData<Data>> {
        return Pager(
            config = PagingConfig(10),
            pagingSourceFactory = { MyPagingSource(retrofit) }
        ).flow
    }
}