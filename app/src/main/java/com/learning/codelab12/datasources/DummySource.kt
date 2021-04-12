package com.learning.codelab12.datasources

import com.learning.codelab12.models.CountryStats

class DummySource {

    fun getSummary() : List<CountryStats>
    {
        var list = ArrayList<CountryStats>()

        list.add(CountryStats("United States of America", "US", 31151495))
        list.add(CountryStats("India", "IN", 13358805))
        list.add(CountryStats("United Kingdom", "GB", 4382880))
        list.add(CountryStats("Russian Federation", "RU", 4580633))

        return list
    }
}