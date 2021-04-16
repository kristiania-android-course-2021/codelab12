package com.learning.codelab12.datasources.retrofit

import com.google.gson.GsonBuilder
import com.learning.codelab12.models.CountryStats
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ApiClient {

    private var covidApi: CovidApi
    init {
        val gson = GsonBuilder().setDateFormat("yyyy-MM-dd'T'HH:mm:ss").create()

        val retrofit = Retrofit.Builder()
            .addConverterFactory(
                GsonConverterFactory.create()
            )
            .addConverterFactory(GsonConverterFactory.create(gson))
            .baseUrl("https://api.covid19api.com/")
            .build()

        covidApi = retrofit.create(CovidApi::class.java)
    }

    fun getSummary(): List<CountryStats> {
        var result = covidApi.getSummary().execute()

        if(result.isSuccessful){
            result.body()?.let { summaryResponse ->
                return summaryResponse.Countries
            }
        }
        return ArrayList<CountryStats>()
    }
}