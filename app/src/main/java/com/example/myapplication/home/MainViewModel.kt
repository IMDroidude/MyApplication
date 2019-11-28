package com.example.myapplication.home

import androidx.lifecycle.viewModelScope
import com.example.myapplication.common.AlertStore
import com.example.myapplication.common.BaseViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import javax.inject.Inject

class MainViewModel @Inject constructor( private val alertStore: AlertStore)
    : BaseViewModel(){

    fun showDialog(){
        viewModelScope.launch {
            delay(4000)

            alertStore.showToast("Alert after 4 seconds.")
        }
    }
}