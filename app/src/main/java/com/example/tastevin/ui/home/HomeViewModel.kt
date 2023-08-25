package com.example.tastevin.ui.home

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.tastevin.domain.Wine
import com.example.tastevin.network.WineApi
import com.example.tastevin.network.asDomainModel
import kotlinx.coroutines.launch
import timber.log.Timber

class HomeViewModel() : ViewModel() {
    val topWines = MutableLiveData<List<Wine>>()

    init {
//        getWine()
        getTopWineList()
    }

//    private fun getWine() {
//        viewModelScope.launch {
//            Timber.tag("JSON").d("Network started")
//            try {
//                Timber.tag("JSON").d(WineApi.retrofitService.getWineById(1).toString())
//            } catch (e: Exception) {
//                Timber.tag("JSON").e(e.toString())
//            }
//        }
//    }

    private fun getTopWineList() {
        viewModelScope.launch {
            try {
                val networkWines = WineApi.retrofitService.getTopWines()
                val wines = networkWines.map { it.asDomainModel() }
                topWines.postValue(wines)
            } catch (e: Exception) {
                Timber.tag("JSON").e(e.toString())
            }
        }
    }
}