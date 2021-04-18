package com.learning.codelab12

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.learning.codelab12.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        var binding  = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

    }
}