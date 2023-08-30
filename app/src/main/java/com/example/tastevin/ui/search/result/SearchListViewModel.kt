package com.example.tastevin.ui.search.result

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.tastevin.domain.Wine
import com.example.tastevin.network.GptRequest
import com.example.tastevin.network.WineApi
import com.example.tastevin.network.asDomainModel
import kotlinx.coroutines.launch

class SearchListViewModel : ViewModel() {
    val searchWines = MutableLiveData<List<Wine>>()

    fun searchWine(searchText: String, isOcr: String) {
        viewModelScope.launch {
            try {
                val networkWines = if (isOcr == "0") {
                    WineApi.retrofitService.searchWine(searchText, "")
                } else {
                    WineApi.retrofitService.searchWinesByOcrText(GptRequest(ocrText = searchText))
                }
                val wines = networkWines.map { it.asDomainModel() }
                searchWines.postValue(wines)
            } catch (_: Exception) {
            }
        }
    }
}