package com.example.tastevin.ui.detail

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.tastevin.domain.Wine
import com.example.tastevin.network.WineApi
import com.example.tastevin.network.asDomainModel
import kotlinx.coroutines.launch
import timber.log.Timber

class DetailViewModel : ViewModel() {
    val wineDetail = MutableLiveData<Wine>()
    val recommendWines = MutableLiveData<List<Wine>>()

    fun recommendWine(id: Int) {
        viewModelScope.launch {
            Timber.tag("JSON").d("Network started")
            try {
//                val networkWines =  WineApi.retrofitService.getWineById(id)
//                wineDetail.postValue(networkWines.wine.asDomainModel())
//                val wines = networkWines.recommendations.map { it.asDomainModel() }
//                recommendWines.postValue(wines)
//                Timber.tag("JSON").d(networkWines.toString())
                val networkWines = WineApi.retrofitService.getWineById(id) // 오류
                val wines = networkWines.asDomainModel()
                recommendWines.postValue(wines)
                Timber.tag("JSON").d(networkWines.toString())
            } catch (e: Exception) {
                Timber.tag("JSON").e(e.toString())
            }
        }
    }
}