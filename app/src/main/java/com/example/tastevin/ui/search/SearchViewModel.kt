package com.example.tastevin.ui.search

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class SearchViewModel : ViewModel() {
    private val _sharedText = MutableLiveData<String>()
    val sharedText: LiveData<String> = _sharedText

    fun setSharedText(text: String) {
        _sharedText.value = text
    }
}