package com.learning.codelab12.repos

import com.learning.codelab12.datasources.retrofit.CovidApiClient
import com.learning.codelab12.datasources.LiveSource
import com.learning.codelab12.models.CountryStats

class CovidRepo {

    private var backend  = CovidApiClient.instance
    private var liveSource  = LiveSource()


    suspend fun getCountriesSummary() : List<CountryStats>  {
        var list  = liveSource.getSummary()

        return list.sortedByDescending {it.TotalConfirmed}

        //return DummySource().getSummary()
    }

}