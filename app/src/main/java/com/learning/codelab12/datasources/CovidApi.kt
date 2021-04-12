package com.learning.codelab12.datasources

import com.learning.codelab12.datasources.response.SummaryResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface CovidApi {

    @GET("summary")
    fun getSummary(): Call<SummaryResponse>

}