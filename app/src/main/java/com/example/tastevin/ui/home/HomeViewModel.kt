package com.example.tastevin.ui.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.tastevin.network.WineApi
import kotlinx.coroutines.launch
import timber.log.Timber

class HomeViewModel() : ViewModel() {

    init {
        getWine()
    }

    private fun getWine() {
        viewModelScope.launch {
            Timber.tag("JSON").d("Network started")
            try {
                Timber.tag("JSON").d(WineApi.retrofitService.getWineById(1).toString())
            } catch (e: Exception) {
                Timber.tag("JSON").e(e.toString())
            }
        }
    }
}