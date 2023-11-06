package com.moondroid.ex_paging.data

data class Response(
    var resultCode: Int,
    var resultMsg: String,
    var totalCount: Int,
    var currentCount: Int,
    var pageNo: Int,
    var perPage: Int,
    var data: List<Data> = emptyList(),
)


data class Data(
    val statisticsField: String,
    val statisticsType: String,
    val statisticsName: String,
    val formName: String,
    val statisticsUrl: String,
)