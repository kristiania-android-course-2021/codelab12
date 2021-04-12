package com.learning.codelab12.repos

import com.learning.codelab12.datasources.ApiClient
import com.learning.codelab12.datasources.DummySource
import com.learning.codelab12.models.CountryStats

class CovidRepo {

    private var backend  = ApiClient.instance


    suspend fun getCountriesSummary() : List<CountryStats>  {
        var list  = backend.getSummary()

        return list.sortedByDescending {it.TotalConfirmed}

        //return DummySource().getSummary()
    }

}