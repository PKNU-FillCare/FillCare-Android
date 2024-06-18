package com.example.fillcare.ui.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.fillcare.data.model.DrugItem
import com.example.fillcare.data.model.DrugResponse
import com.example.fillcare.data.service.DrugApi
import kotlinx.coroutines.launch
import timber.log.Timber

class RecognizerViewModel : ViewModel() {

    private val _drugList =  MutableLiveData<List<DrugItem>>()
    val drugList  :  LiveData<List<DrugItem>> get() =  _drugList


//    fun getDrugInfo() {
//        viewModelScope.launch{
//            DrugApi.retrofitService.getDrugList(SERVICE_KEY,"타이레놀","json")
//                .onSuccess {
//                    Log.d("성공","성공 : ${it}")
//                    Timber.d("getdrug list request success")
//                }
//                .onFailure {
//                    Log.d("실패", "실패 : $it")
//                    Timber.e("getdrug list request failed")
//                }
//        }
//    }

    fun getDrugInfo() {
        viewModelScope.launch {
            try {
               val response = DrugApi.retrofitService.getDrugList(
                    SERVICE_KEY,
                    "타이레놀",
                    "json"
                )
                _drugList.value = response.body.items!!
                Log.d("성공",_drugList.value.toString())

            } catch (e: Exception) {
                Log.d("drug", e.toString())
            }

        }
    }

    companion object {
        const val SERVICE_KEY = "D5Pn1X94hE69T8eSXEWBopXajX0xhBgzDbAEkf5CCiJL4jp2I598D4ZCP9gNsnM8tRGYfL6hKiFC5KYccYVuSA%3D%3D"
    }
}