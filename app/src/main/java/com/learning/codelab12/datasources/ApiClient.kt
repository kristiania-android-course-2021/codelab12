package com.learning.codelab12.datasources

import com.google.gson.GsonBuilder
import com.learning.codelab12.models.CountryStats
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ApiClient {


    fun getSummary(): List<CountryStats> {
       var result = api.getSummary().execute()

        if(result.isSuccessful){
            result.body()?.let { summaryResponse ->
                return summaryResponse.Countries
           }
        }
        return ArrayList<CountryStats>()
    }

    private var api: CovidApi

    companion object{
        val instance  : ApiClient  by lazy {
            ApiClient()
        }
    }

    init {
        val gson = GsonBuilder().setDateFormat("yyyy-MM-dd'T'HH:mm:ss").create()

        val retrofit = Retrofit.Builder()
            .addConverterFactory(
                GsonConverterFactory.create()
            )
            .addConverterFactory(GsonConverterFactory.create(gson))
            .baseUrl("https://api.covid19api.com/")
            .build()

        api = retrofit.create(CovidApi::class.java)
    }
}