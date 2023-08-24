package com.example.tastevin.ui.home

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.tastevin.network.WineApi
import kotlinx.coroutines.launch

class HomeViewModel : ViewModel() {

    init {
        getWine()
    }

    private fun getWine() {
        viewModelScope.launch {
            Log.d("JSON", "Network started")
            try {
                Log.d("JSON", WineApi.retrofitService.getWineById(1).toString())
            } catch (e: Exception) {
                Log.e("JSON", e.toString())
            }
        }
    }
}