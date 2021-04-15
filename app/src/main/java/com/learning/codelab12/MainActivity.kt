package com.learning.codelab12

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.learning.codelab12.adapters.CountryListAdapter
import com.learning.codelab12.databinding.ActivityMainBinding
import com.learning.codelab12.datasources.DummySource
import com.learning.codelab12.models.CountryStats
import com.learning.codelab12.viewmodels.MainViewModel

class MainActivity : AppCompatActivity() {

    private lateinit var listAdapter : CountryListAdapter
    private val viewModel = MainViewModel()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        var binding  = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        listAdapter = CountryListAdapter(ArrayList())

        binding.recyclerView.layoutManager = LinearLayoutManager(this)
        binding.recyclerView.adapter = listAdapter

        viewModel.liveStats.observe(this, { list->
            listAdapter.update(list)
        })
    }

    override fun onResume() {
        super.onResume()
        viewModel.refresh()
    }

}