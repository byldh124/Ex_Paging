package com.moondroid.ex_paging.network

import com.moondroid.ex_paging.data.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface RetrofitExService {
    @GET("getMolitStatList")
    suspend fun getData(
        @Query("serviceKey") serviceKey: String,
        @Query("pageNo") pageNo: String,
        @Query("numOfRows") numOfRows: String,
        @Query("returnType") returnType: String,
    ): Response
}