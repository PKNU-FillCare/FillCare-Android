package com.example.fillcare.ui.search

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.fillcare.data.model.DrugItem
import com.example.fillcare.data.service.DrugApi
import com.example.fillcare.ui.viewmodel.RecognizerViewModel
import kotlinx.coroutines.launch

class SearchViewModel : ViewModel() {

    private val _drugList =  MutableLiveData<List<DrugItem>>()
    val drugList  : LiveData<List<DrugItem>> get() =  _drugList


    fun searchDrugInfo(itemName: String) {
        viewModelScope.launch {
            try {
                val response = DrugApi.retrofitService.getDrugList(
                    RecognizerViewModel.SERVICE_KEY,
                    itemName,
                    "json"
                )
                _drugList.value = response.body.items!!
                Log.d("성공",_drugList.value.toString())

            } catch (e: Exception) {
                Log.d("drug", e.toString())
            }

        }
    }
}