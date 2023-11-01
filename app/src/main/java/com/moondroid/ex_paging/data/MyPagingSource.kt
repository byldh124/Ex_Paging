package com.moondroid.ex_paging.data

import android.util.Log
import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.moondroid.ex_paging.common.Constant
import retrofit2.Retrofit
import javax.inject.Inject

class MyPagingSource(private val retrofit: Retrofit) : PagingSource<Int, Data>() {
    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Data> {
        val page = params.key ?: 1
        return try {
            val service = retrofit.create(ApiService::class.java)
            val response = service.getData(
                serviceKey = Constant.SERVICE_KEY,
                pageNo = page.toString(),
                numOfRows = params.loadSize.toString(),
                returnType = Constant.RETURN_TYPE
            )
            Log.e("TAG", "RESPONSE :$response")
            val items = response.data
            LoadResult.Page(
                data = items,
                prevKey = if (page == 1) null else page - 1,
                nextKey = if (items.isEmpty()) null else page + (params.loadSize / 10)
            )
        } catch (e: Exception) {
            LoadResult.Error(e)
        }
    }

    override fun getRefreshKey(state: PagingState<Int, Data>): Int? {
        return state.anchorPosition?.let { anchorPosition ->
            state.closestPageToPosition(anchorPosition)?.prevKey?.plus(1)
                ?: state.closestPageToPosition(anchorPosition)?.nextKey?.minus(1)
        }
    }

}