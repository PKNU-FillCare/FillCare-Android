package com.example.fillcare.ui.search

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.SearchView
import androidx.lifecycle.Observer
import com.example.fillcare.data.model.DrugItem
import com.example.fillcare.databinding.ActivitySearchBinding


class SearchActivity : AppCompatActivity() {

    private lateinit var binding : ActivitySearchBinding
    private val viewModel : SearchViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivitySearchBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        //viewModel.searchDrugInfo(itemName = "타이레놀")
        val searchObserver = Observer<List<DrugItem>> {
            binding.tvData.text= it.toString()

        }

        viewModel.drugList.observe(this,searchObserver)

        initSearchView()

    }

    private fun initSearchView() {
        binding.search.setOnQueryTextListener(object: SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                if (query!= null) {
                    viewModel.searchDrugInfo(query)
                }
         return false
            }

            override fun onQueryTextChange(newText: String?): Boolean {

                return true
            }
        })
    }



}