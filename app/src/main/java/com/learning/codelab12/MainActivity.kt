package com.learning.codelab12

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import com.learning.codelab12.adapters.CountryListAdapter
import com.learning.codelab12.databinding.ActivityMainBinding
import com.learning.codelab12.models.CountryStats
import com.learning.codelab12.viewmodels.MainViewModel

class MainActivity : AppCompatActivity() {

    private val viewModel = MainViewModel()
    private var listAdapter = CountryListAdapter(ArrayList<CountryStats>())

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        var binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.recyclerView.layoutManager = LinearLayoutManager(this)
        binding.recyclerView.adapter = listAdapter

        viewModel.liveStats.observe(this, { newList->
            listAdapter.update(newList)
        })
    }

    override fun onResume() {
        super.onResume()
        viewModel.refresh()
    }
}