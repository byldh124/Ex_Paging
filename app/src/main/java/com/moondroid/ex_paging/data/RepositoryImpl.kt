package com.moondroid.ex_paging.data

import com.moondroid.ex_paging.common.Constant
import com.moondroid.ex_paging.domain.Repository
import com.moondroid.ex_paging.network.MyRetrofit
import com.moondroid.ex_paging.network.RetrofitExService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import retrofit2.Retrofit
import javax.inject.Inject

class RepositoryImpl @Inject constructor(private val retrofit: Retrofit) : Repository {
    override fun getData(pageNo: String): Flow<List<Data>> {
        return flow {
            val service = MyRetrofit.retrofit.create(RetrofitExService::class.java)
            service.getData(Constant.SERVICE_KEY, pageNo, Constant.NUM_OF_ROWS, Constant.RETURN_TYPE).run {
                emit(this.data)
            }
        }.flowOn(Dispatchers.IO)
    }
}