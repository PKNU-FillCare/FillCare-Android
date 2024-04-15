package com.example.fillcare.ui.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.fillcare.data.service.DrugApi
import kotlinx.coroutines.launch

class RecognizerViewModel : ViewModel() {

    init {
        getDrugInfo()
    }


      fun getDrugInfo() {
        viewModelScope.launch{
            try {
                val result = DrugApi.retrofitService.getDrugList("D5Pn1X94hE69T8eSXEWBopXajX0xhBgzDbAEkf5CCiJL4jp2I598D4ZCP9gNsnM8tRGYfL6hKiFC5KYccYVuSA%3D%3D","타이레놀","json")
                Log.d("drug",result.toString())
            }
            catch (e:Exception) {
                Log.d("drug",e.toString())
            }

        }

    }
}