package com.learning.codelab12.repos

import com.learning.codelab12.datasources.ApiClient
import com.learning.codelab12.datasources.DummySource
import com.learning.codelab12.datasources.LiveSource
import com.learning.codelab12.models.CountryStats

class CovidRepo {

    private var backend  = ApiClient.instance
    private var liveSource  = LiveSource()


    suspend fun getCountriesSummary() : List<CountryStats>  {
        var list  = liveSource.getSummary()

        return list.sortedByDescending {it.TotalConfirmed}

        //return DummySource().getSummary()
    }

}