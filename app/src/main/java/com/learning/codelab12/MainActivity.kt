package com.learning.codelab12

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import com.learning.codelab12.adapters.CountryListAdapter
import com.learning.codelab12.databinding.ActivityMainBinding
import com.learning.codelab12.datasources.DummySource
import com.learning.codelab12.models.CountryStats

class MainActivity : AppCompatActivity() {

    private var listAdapter = CountryListAdapter(ArrayList<CountryStats>())

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        var binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.recyclerView.layoutManager = LinearLayoutManager(this)
        binding.recyclerView.adapter = listAdapter

        listAdapter.update(DummySource().getSummary())
    }
}