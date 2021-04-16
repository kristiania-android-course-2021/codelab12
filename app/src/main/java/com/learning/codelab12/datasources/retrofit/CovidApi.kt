package com.learning.codelab12.datasources.retrofit

import com.learning.codelab12.datasources.retrofit.SummaryResponse
import retrofit2.Call
import retrofit2.http.GET

interface CovidApi {

    @GET("summary")
    fun getSummary(): Call<SummaryResponse>

}