package com.learning.codelab12.repos

import com.learning.codelab12.datasources.retrofit.CovidApiClient
import com.learning.codelab12.datasources.LiveSource
import com.learning.codelab12.models.CountryStats

class CovidRepo {

    private val covidApiClient = CovidApiClient()
    private val liveSource  = LiveSource()


    suspend fun getCountriesSummary() : List<CountryStats>  {
        var list  = covidApiClient.getSummary()
        return list.sortedByDescending {it.TotalConfirmed}
    }

}