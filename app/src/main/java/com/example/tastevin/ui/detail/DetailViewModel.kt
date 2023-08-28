package com.example.tastevin.ui.detail

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.tastevin.network.NetworkWine
import com.example.tastevin.network.WineApi
import kotlinx.coroutines.launch
import timber.log.Timber

class DetailViewModel : ViewModel() {
    private val _recommendWines = MutableLiveData<List<NetworkWine>>()
    val recommendWines: LiveData<List<NetworkWine>> = _recommendWines

    // 추천 와인들의 ID를 받아와서 해당 와인들의 정보를 가져오는 함수
    fun fetchRecommendWines(recommendIds: List<Int>) {
        viewModelScope.launch {
            try {
                val networkWines = recommendIds.map { id ->
                    WineApi.retrofitService.getWineById(id)
                }
                _recommendWines.postValue(networkWines)
            } catch (e: Exception) {
                Timber.e(e, "Error fetching recommend wines")
            }
        }
    }
}