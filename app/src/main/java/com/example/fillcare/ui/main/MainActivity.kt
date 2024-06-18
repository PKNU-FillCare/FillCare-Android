package com.example.fillcare.ui.main

import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.lifecycleScope
import com.example.fillcare.R
import com.example.fillcare.ui.viewmodel.RecognizerViewModel
import kotlinx.coroutines.launch
import timber.log.Timber


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val viewModel = RecognizerViewModel()

        lifecycleScope.launch {
            viewModel.getDrugInfo()
        }
       // Timber.d("druglist : ${viewModel.drugList}")


        }
}