package com.moondroid.ex_paging.network

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

object MyRetrofit {

    private var okHttpClient: OkHttpClient? = null

    val retrofit: Retrofit
        get() {
            return Retrofit.Builder()
                .baseUrl("https://apis.data.go.kr/1613000/pubStorgeOpenApiService/")
                .addConverterFactory(GsonConverterFactory.create())
                .client(getOkHttpClient())
                .build()
        }

    private fun initOkHttpClient(): OkHttpClient {
        val client = OkHttpClient.Builder()
        client.connectTimeout(60, TimeUnit.SECONDS)
        client.readTimeout(60, TimeUnit.SECONDS)
        client.writeTimeout(60, TimeUnit.SECONDS)
        // 참고: addInterceptor 사용하기 위해서 gradle 파일에 compileOptions, kotlinOptions 추가해 주어야 함
        return client.build()
    }

    private fun getOkHttpClient(): OkHttpClient {
        if (okHttpClient == null) {
            okHttpClient = initOkHttpClient()
        }
        return okHttpClient!!
    }
}