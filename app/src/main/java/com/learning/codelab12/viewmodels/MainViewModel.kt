package com.learning.codelab12.viewmodels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.learning.codelab12.models.CountryStats
import com.learning.codelab12.repos.CovidRepo
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MainViewModel : ViewModel() {
    val liveStats = MutableLiveData<List<CountryStats>> (ArrayList<CountryStats>())
    private var repo = CovidRepo()

    fun refresh() {
        viewModelScope.launch {

            var result = withContext(Dispatchers.IO) {
                repo.getCountriesSummary()
            }
            liveStats.value = result
        }
    }

}