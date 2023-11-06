package com.moondroid.ex_paging.data

import com.moondroid.ex_paging.data.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
    @GET("getMolitStatList")
    suspend fun getData(
        @Query("serviceKey") serviceKey: String,
        @Query("pageNo") pageNo: String,
        @Query("numOfRows") numOfRows: String,
        @Query("returnType") returnType: String,
    ): Response
}