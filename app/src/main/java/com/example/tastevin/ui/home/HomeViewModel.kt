package com.example.tastevin.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.tastevin.domain.Wine
import com.example.tastevin.network.NetworkWine
import com.example.tastevin.network.WineApi
import com.example.tastevin.network.asDomainModel
import kotlinx.coroutines.launch
import timber.log.Timber

class HomeViewModel() : ViewModel() {
    private val _wineList = MutableLiveData<List<Wine>>()
    val wineList: LiveData<List<Wine>> = _wineList

    init {
        getWineList()
    }

    private fun getWineList() {
        viewModelScope.launch {
            try {
                val networkWines = WineApi.retrofitService.getTopWines()
                val wineList = networkWines.map { it.asDomainModel() }
                _wineList.postValue(wineList)
            } catch (e: Exception) {
                Timber.e(e, "Error getting wine list")
            }
        }
    }

//    init {
//        getWine()
//    }
//
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
}