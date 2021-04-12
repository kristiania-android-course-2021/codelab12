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

    private val liveData = MutableLiveData<List<CountryStats>> (ArrayList<CountryStats>())
    private val loading = MutableLiveData<Boolean> (false)


    private val repo = CovidRepo()

    fun getCountriesSummary() :MutableLiveData<List<CountryStats>> {

        loading.value = true
        viewModelScope.launch  {
            var result =  withContext(Dispatchers.IO){
                repo.getCountriesSummary()
            }

            loading.value = false
            liveData.value = result
        }
        return liveData
    }

    fun getLoading() : MutableLiveData<Boolean>{
        return loading
    }

}