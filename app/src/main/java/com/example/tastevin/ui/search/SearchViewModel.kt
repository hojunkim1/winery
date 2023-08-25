package com.example.tastevin.ui.search

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.tastevin.domain.Wine
import com.example.tastevin.network.WineApi
import com.example.tastevin.network.asDomainModel
import kotlinx.coroutines.launch
import timber.log.Timber

class SearchViewModel() : ViewModel() {
//    val searchWines = MutableLiveData<List<Wine>>()
//
//    fun searchWine(searchText: String) {
//        viewModelScope.launch {
//            Timber.tag("JSON").d("Network started")
//            try {
//                val networkWines = WineApi.retrofitService.searchWine(searchText, "")
//                val wines = networkWines.map { it.asDomainModel() }
//                searchWines.postValue(wines)
//                Timber.tag("JSON").d(networkWines.toString())
//            } catch (e: Exception) {
//                Timber.tag("JSON").e(e.toString())
//            }
//        }
//    }
}