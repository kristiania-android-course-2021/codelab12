package com.learning.codelab12.repos

import com.learning.codelab12.datasources.DummySource
import com.learning.codelab12.models.CountryStats

class CovidRepo {
    suspend fun getCountriesSummary() : List<CountryStats>{
        return DummySource().getSummary()
    }
}