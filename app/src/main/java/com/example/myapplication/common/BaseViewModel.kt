package com.example.myapplication.common

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

open class BaseViewModel : ViewModel() {

    init {
        viewModelScope.launch {

        }
    }
}