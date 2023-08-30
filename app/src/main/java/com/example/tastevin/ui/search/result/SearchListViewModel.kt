package com.example.tastevin.ui.search.result

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.tastevin.domain.Wine
import com.example.tastevin.network.GptRequest
import com.example.tastevin.network.WineApi
import com.example.tastevin.network.asDomainModel
import kotlinx.coroutines.launch
import timber.log.Timber

class SearchListViewModel : ViewModel() {

    companion object {
        const val JSON_TAG = "JSON"
    }

    val searchWines = MutableLiveData<List<Wine>>()

    fun searchWine(searchText: String, isOcr: String) {
        viewModelScope.launch {
            Timber.tag(JSON_TAG).d("Network started")
            try {
                val networkWines = if (isOcr == "0") {
                    WineApi.retrofitService.searchWine(searchText, "")
                } else {
                    WineApi.retrofitService.searchWinesByOcrText(GptRequest(ocrText = searchText))
                }
                val wines = networkWines.map { it.asDomainModel() }
                searchWines.postValue(wines)
                Timber.tag(JSON_TAG).d(networkWines.toString())
            } catch (e: Exception) {
                Timber.tag(JSON_TAG).e(e.toString())
            }
        }
    }
}