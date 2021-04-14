package com.learning.codelab12.datasources

import com.learning.codelab12.models.CountryStats

class DummySource {

    fun getSummary() : List<CountryStats>
    {
        var list = ArrayList<CountryStats>()

        list.add(CountryStats("India", "IN", 13527717))
        list.add(CountryStats("Brazil", "BR", 13482023))
        list.add(CountryStats("France", "FR", 5119585))
        list.add(CountryStats("Russian Federation", "RU", 4589209))
        list.add(CountryStats("United Kingdom", "GB", 4384610))
        list.add(CountryStats("Turkey", "TR", 3903573))
        list.add(CountryStats("Italy", "IT", 3769814))
        list.add(CountryStats("Spain", "ES", 3347512))
        list.add(CountryStats("Germany", "DE", 3012158))
        list.add(CountryStats("Poland", "PL", 2586647))
        list.add(CountryStats("Argentina", "AR", 2551999))
        list.add(CountryStats("Colombia", "CO", 2536198))
        list.add(CountryStats("Mexico", "MX", 2280213))
        list.add(CountryStats("Iran, Islamic Republic of", "IR", 2093452))
        list.add(CountryStats("Ukraine", "UA", 1905430))
        list.add(CountryStats("Peru", "PE", 1647694))
        list.add(CountryStats("Czech Republic", "CZ", 1581184))
        list.add(CountryStats("Indonesia", "ID", 1571824))
        list.add(CountryStats("South Africa", "ZA", 1559113))
        list.add(CountryStats("Netherlands", "NL", 1350665))
        list.add(CountryStats("Chile", "CL", 1076499))
        list.add(CountryStats("Romania", "RO", 1008490))
        list.add(CountryStats("Iraq", "IQ", 932899))
        list.add(CountryStats("Belgium", "BE", 925476))
        list.add(CountryStats("Canada", "CA", 906836))
        list.add(CountryStats("Philippines", "PH", 876225))
        list.add(CountryStats("Sweden", "SE", 857401))
        list.add(CountryStats("Israel", "IL", 836158))
        list.add(CountryStats("Portugal", "PT", 827765))
        list.add(CountryStats("Pakistan", "PK", 725602))


        return list
    }
}